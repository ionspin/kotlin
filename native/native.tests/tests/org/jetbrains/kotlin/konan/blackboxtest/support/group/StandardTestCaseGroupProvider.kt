/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.konan.blackboxtest.support.group

import org.jetbrains.kotlin.konan.blackboxtest.support.*
import org.jetbrains.kotlin.konan.blackboxtest.support.TestCase.NoTestRunnerExtras
import org.jetbrains.kotlin.konan.blackboxtest.support.TestCase.WithTestRunnerExtras
import org.jetbrains.kotlin.konan.blackboxtest.support.settings.GeneratedSources
import org.jetbrains.kotlin.konan.blackboxtest.support.settings.Settings
import org.jetbrains.kotlin.konan.blackboxtest.support.settings.TestRoots
import org.jetbrains.kotlin.konan.blackboxtest.support.util.*
import org.jetbrains.kotlin.konan.blackboxtest.support.util.DEFAULT_FILE_NAME
import org.jetbrains.kotlin.konan.blackboxtest.support.util.ThreadSafeFactory
import org.jetbrains.kotlin.konan.blackboxtest.support.util.computeGeneratedSourcesDir
import org.jetbrains.kotlin.konan.blackboxtest.support.util.computePackageName
import org.jetbrains.kotlin.test.directives.model.Directive
import org.jetbrains.kotlin.test.services.JUnit5Assertions
import org.jetbrains.kotlin.test.services.JUnit5Assertions.assertEquals
import org.jetbrains.kotlin.test.services.JUnit5Assertions.assertFalse
import org.jetbrains.kotlin.test.services.JUnit5Assertions.assertNotEquals
import org.jetbrains.kotlin.test.services.JUnit5Assertions.assertTrue
import org.jetbrains.kotlin.test.services.JUnit5Assertions.fail
import org.jetbrains.kotlin.test.services.impl.RegisteredDirectivesParser
import org.jetbrains.kotlin.utils.addToStdlib.cast
import java.io.File

internal class StandardTestCaseGroupProvider(private val settings: Settings) : TestCaseGroupProvider {
    // Load test cases in groups on demand.
    private val lazyTestCaseGroups = ThreadSafeFactory<TestCaseGroupId.TestDataDir, TestCaseGroup?> { testCaseGroupId ->
        val testDataFiles = testCaseGroupId.dir.listFiles()
            ?: return@ThreadSafeFactory null // `null` means that there is no such testDataDir.

        val testCases = testDataFiles.mapNotNull { testDataFile ->
            if (!testDataFile.isFile || testDataFile.extension != "kt")
                return@mapNotNull null

            createTestCase(testDataFile)
        }

        TestCaseGroup.Default(disabledTestCaseIds = emptySet(), testCases = testCases)
    }

    override fun getTestCaseGroup(testCaseGroupId: TestCaseGroupId): TestCaseGroup? {
        assertTrue(testCaseGroupId is TestCaseGroupId.TestDataDir)
        return lazyTestCaseGroups[testCaseGroupId.cast()]
    }

    private fun createTestCase(testDataFile: File): TestCase {
        val generatedSourcesDir = computeGeneratedSourcesDir(
            testDataBaseDir = settings.get<TestRoots>().baseDir,
            testDataFile = testDataFile,
            generatedSourcesBaseDir = settings.get<GeneratedSources>().testSourcesDir
        )

        val nominalPackageName = computePackageName(
            testDataBaseDir = settings.get<TestRoots>().baseDir,
            testDataFile = testDataFile
        )

        val testModules = hashMapOf<String, TestModule.Exclusive>()
        var currentTestModule: TestModule.Exclusive? = null

        var currentTestFileName: String? = null
        val currentTestFileText = StringBuilder()

        val directivesParser = RegisteredDirectivesParser(TestDirectives, JUnit5Assertions)
        var lastParsedDirective: Directive? = null

        fun switchTestModule(newTestModule: TestModule.Exclusive, location: Location): TestModule.Exclusive {
            // Don't register new test module if there is another one with the same name.
            val testModule = testModules.getOrPut(newTestModule.name) { newTestModule }
            assertTrue(testModule === newTestModule || testModule.haveSameSymbols(newTestModule)) {
                """
                    $location: Two declarations of the same module with different dependencies or friends found:
                    $testModule
                    $newTestModule
                """.trimIndent()
            }

            currentTestModule = testModule
            return testModule
        }

        fun beginTestFile(fileName: String) {
            assertEquals(null, currentTestFileName)
            currentTestFileName = fileName
        }

        fun finishTestFile(forceFinish: Boolean, location: Location) {
            val needToFinish = forceFinish
                    || currentTestFileName != null
                    || (currentTestFileName == null /*&& testFiles.isEmpty()*/ && currentTestFileText.hasAnythingButComments())

            if (needToFinish) {
                val fileName = currentTestFileName ?: DEFAULT_FILE_NAME
                val testModule = currentTestModule ?: switchTestModule(TestModule.newDefaultModule(), location)

                testModule.files += TestFile.createUncommitted(
                    location = generatedSourcesDir.resolve(testModule.name).resolve(fileName),
                    module = testModule,
                    text = currentTestFileText
                )

                currentTestFileText.clear()
                repeat(location.lineNumber ?: 0) { currentTestFileText.appendLine() }
                currentTestFileName = null
            }
        }

        testDataFile.readLines().forEachIndexed { lineNumber, line ->
            val location = Location(testDataFile, lineNumber)
            val expectFileDirectiveAfterModuleDirective =
                lastParsedDirective == TestDirectives.MODULE // Only FILE directive may follow MODULE directive.

            val rawDirective = RegisteredDirectivesParser.parseDirective(line)
            if (rawDirective != null) {
                val parsedDirective = try {
                    directivesParser.convertToRegisteredDirective(rawDirective)
                } catch (e: AssertionError) {
                    // Enhance error message with concrete test data file and line number where the error has happened.
                    throw AssertionError(
                        """
                            $location: Error while parsing directive in test data file.
                            Cause: ${e.message}
                        """.trimIndent(),
                        e
                    )
                }

                if (parsedDirective != null) {
                    when (val directive = parsedDirective.directive) {
                        TestDirectives.FILE -> {
                            val newFileName = parseFileName(parsedDirective, location)
                            finishTestFile(forceFinish = false, location)
                            beginTestFile(newFileName)
                        }
                        else -> {
                            assertFalse(expectFileDirectiveAfterModuleDirective) {
                                "$location: Directive $directive encountered after ${TestDirectives.MODULE} directive but was expecting ${TestDirectives.FILE}"
                            }

                            when (directive) {
                                TestDirectives.MODULE -> {
                                    finishTestFile(forceFinish = false, location)
                                    switchTestModule(parseModule(parsedDirective, location), location)
                                }
                                else -> {
                                    assertNotEquals(TestDirectives.FILE, lastParsedDirective) {
                                        "$location: Global directive $directive encountered after ${TestDirectives.FILE} directive"
                                    }
                                    assertNotEquals(TestDirectives.MODULE, lastParsedDirective) {
                                        "$location: Global directive $directive encountered after ${TestDirectives.MODULE} directive"
                                    }

                                    directivesParser.addParsedDirective(parsedDirective)
                                }
                            }
                        }
                    }

                    currentTestFileText.appendLine()
                    lastParsedDirective = parsedDirective.directive
                    return@forEachIndexed
                }
            }

            if (expectFileDirectiveAfterModuleDirective) {
                // Was expecting a line with the FILE directive as this is the only possible continuation of a line with
                // the MODULE directive, but failed.
                fail { "$location: ${TestDirectives.FILE} directive expected after ${TestDirectives.MODULE} directive" }
            }

            currentTestFileText.appendLine(line)
        }

        val location = Location(testDataFile)
        finishTestFile(forceFinish = true, location)

        val registeredDirectives = directivesParser.build()

        val freeCompilerArgs = parseFreeCompilerArgs(registeredDirectives, location)
        val expectedOutputDataFile = parseOutputDataFile(baseDir = testDataFile.parentFile, registeredDirectives, location)
        val testKind = parseTestKind(registeredDirectives, location)

        if (testKind == TestKind.REGULAR) {
            // Fix package declarations to avoid unintended conflicts between symbols with the same name in different test cases.
            fixPackageNames(testModules.values, nominalPackageName, testDataFile)
        }

        val testCase = TestCase(
            id = TestCaseId.TestDataFile(testDataFile),
            kind = testKind,
            modules = testModules.values.toSet(),
            freeCompilerArgs = freeCompilerArgs,
            nominalPackageName = nominalPackageName,
            expectedOutputDataFile = expectedOutputDataFile,
            extras = if (testKind == TestKind.STANDALONE_NO_TR)
                NoTestRunnerExtras(
                    entryPoint = parseEntryPoint(registeredDirectives, location),
                    inputDataFile = parseInputDataFile(baseDir = testDataFile.parentFile, registeredDirectives, location)
                )
            else
                WithTestRunnerExtras(runnerType = parseTestRunner(registeredDirectives, location))
        )
        testCase.initialize(findSharedModule = null)

        return testCase
    }

    companion object {
        private fun fixPackageNames(testModules: Collection<TestModule.Exclusive>, basePackageName: PackageName, testDataFile: File) {
            testModules.forEach { testModule ->
                testModule.files.forEach { testFile ->
                    val firstMeaningfulLine = testFile.text.dropNonMeaningfulLines().firstOrNull()

                    // Retrieve the package name if it is declared inside the test file.
                    val existingPackageName = firstMeaningfulLine?.getExistingPackageName()
                    if (existingPackageName != null) {
                        // Validate it.
                        assertTrue(existingPackageName.startsWith(basePackageName)) {
                            val location = Location(testDataFile, firstMeaningfulLine.number)
                            """
                               $location: Invalid package name declaration found: $firstMeaningfulLine
                                Expected: package $basePackageName
                            """.trimIndent()
                        }
                    } else {
                        // Add package declaration.
                        testFile.update { text -> "package $basePackageName $text" }
                    }
                }
            }
        }
    }
}
