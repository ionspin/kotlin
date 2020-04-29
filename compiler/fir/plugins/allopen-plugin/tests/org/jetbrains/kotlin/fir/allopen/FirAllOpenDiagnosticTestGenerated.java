/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.allopen;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/fir/plugins/allopen-plugin/testData")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class FirAllOpenDiagnosticTestGenerated extends AbstractFirAllOpenDiagnosticTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    public void testAllFilesPresentInTestData() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/plugins/allopen-plugin/testData"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @TestMetadata("compiler/fir/plugins/allopen-plugin/testData/status")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Status extends AbstractFirAllOpenDiagnosticTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        public void testAllFilesPresentInStatus() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/plugins/allopen-plugin/testData/status"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @TestMetadata("metaAnnotation.kt")
        public void testMetaAnnotation() throws Exception {
            runTest("compiler/fir/plugins/allopen-plugin/testData/status/metaAnnotation.kt");
        }

        @TestMetadata("simpleAnnotation.kt")
        public void testSimpleAnnotation() throws Exception {
            runTest("compiler/fir/plugins/allopen-plugin/testData/status/simpleAnnotation.kt");
        }
    }
}
