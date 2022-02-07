/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.visualizer.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link GenerateNewCompilerTests.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder")
@TestDataPath("$PROJECT_ROOT")
public class FirVisualizerForRawFirDataGenerated extends AbstractFirVisualizerTest {
    @Test
    public void testAllFilesPresentInRawBuilder() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Nested
    @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse")
    @TestDataPath("$PROJECT_ROOT")
    public class CompilerCourse {
        @Test
        @TestMetadata("01.capturedTypeParameters.kt")
        public void test01_capturedTypeParameters() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/01.capturedTypeParameters.kt");
        }

        @Test
        @TestMetadata("02.enumEntries.kt")
        public void test02_enumEntries() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/02.enumEntries.kt");
        }

        @Test
        @TestMetadata("03.whenSubjects.kt")
        public void test03_whenSubjects() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/03.whenSubjects.kt");
        }

        @Test
        @TestMetadata("04.ifToWhen.kt")
        public void test04_ifToWhen() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/04.ifToWhen.kt");
        }

        @Test
        @TestMetadata("05.forToWhile.kt")
        public void test05_forToWhile() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/05.forToWhile.kt");
        }

        @Test
        @TestMetadata("06.components.kt")
        public void test06_components() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/06.components.kt");
        }

        @Test
        @TestMetadata("07.safeCalls.kt")
        public void test07_safeCalls() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/07.safeCalls.kt");
        }

        @Test
        @TestMetadata("08.binaryOperators.kt")
        public void test08_binaryOperators() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/08.binaryOperators.kt");
        }

        @Test
        @TestMetadata("09.unaryOperators.kt")
        public void test09_unaryOperators() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/09.unaryOperators.kt");
        }

        @Test
        @TestMetadata("10.arrayAccess.kt")
        public void test10_arrayAccess() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/10.arrayAccess.kt");
        }

        @Test
        @TestMetadata("11.labels.kt")
        public void test11_labels() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/11.labels.kt");
        }

        @Test
        @TestMetadata("12.arrayAccessAndSafeCall.kt")
        public void test12_arrayAccessAndSafeCall() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse/12.arrayAccessAndSafeCall.kt");
        }

        @Test
        public void testAllFilesPresentInCompilerCourse() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/compilerCourse"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }
    }

    @Nested
    @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations")
    @TestDataPath("$PROJECT_ROOT")
    public class Declarations {
        @Test
        public void testAllFilesPresentInDeclarations() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("annotation.kt")
        public void testAnnotation() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotation.kt");
        }

        @Test
        @TestMetadata("annotationsOnNullableParenthesizedTypes.kt")
        public void testAnnotationsOnNullableParenthesizedTypes() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationsOnNullableParenthesizedTypes.kt");
        }

        @Test
        @TestMetadata("annotationsOnParenthesizedTypes.kt")
        public void testAnnotationsOnParenthesizedTypes() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/annotationsOnParenthesizedTypes.kt");
        }

        @Test
        @TestMetadata("complexTypes.kt")
        public void testComplexTypes() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/complexTypes.kt");
        }

        @Test
        @TestMetadata("constructorInObject.kt")
        public void testConstructorInObject() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/constructorInObject.kt");
        }

        @Test
        @TestMetadata("constructorOfAnonymousObject.kt")
        public void testConstructorOfAnonymousObject() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/constructorOfAnonymousObject.kt");
        }

        @Test
        @TestMetadata("delegates.kt")
        public void testDelegates() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/delegates.kt");
        }

        @Test
        @TestMetadata("derivedClass.kt")
        public void testDerivedClass() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/derivedClass.kt");
        }

        @Test
        @TestMetadata("emptyAnonymousObject.kt")
        public void testEmptyAnonymousObject() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/emptyAnonymousObject.kt");
        }

        @Test
        @TestMetadata("enums.kt")
        public void testEnums() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/enums.kt");
        }

        @Test
        @TestMetadata("enums2.kt")
        public void testEnums2() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/enums2.kt");
        }

        @Test
        @TestMetadata("expectActual.kt")
        public void testExpectActual() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/expectActual.kt");
        }

        @Test
        @TestMetadata("external.kt")
        public void testExternal() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/external.kt");
        }

        @Test
        @TestMetadata("F.kt")
        public void testF() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/F.kt");
        }

        @Test
        @TestMetadata("functionTypes.kt")
        public void testFunctionTypes() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/functionTypes.kt");
        }

        @Test
        @TestMetadata("genericFunctions.kt")
        public void testGenericFunctions() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/genericFunctions.kt");
        }

        @Test
        @TestMetadata("genericProperty.kt")
        public void testGenericProperty() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/genericProperty.kt");
        }

        @Test
        @TestMetadata("initBlockWithDeclarations.kt")
        public void testInitBlockWithDeclarations() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/initBlockWithDeclarations.kt");
        }

        @Test
        @TestMetadata("nestedClass.kt")
        public void testNestedClass() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/nestedClass.kt");
        }

        @Test
        @TestMetadata("NestedOfAliasedType.kt")
        public void testNestedOfAliasedType() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/NestedOfAliasedType.kt");
        }

        @Test
        @TestMetadata("NestedSuperType.kt")
        public void testNestedSuperType() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/NestedSuperType.kt");
        }

        @Test
        @TestMetadata("noPrimaryConstructor.kt")
        public void testNoPrimaryConstructor() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/noPrimaryConstructor.kt");
        }

        @Test
        @TestMetadata("propertyWithBackingField.kt")
        public void testPropertyWithBackingField() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/propertyWithBackingField.kt");
        }

        @Test
        @TestMetadata("propertyWithBackingFieldDifferentTypes.kt")
        public void testPropertyWithBackingFieldDifferentTypes() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/propertyWithBackingFieldDifferentTypes.kt");
        }

        @Test
        @TestMetadata("simpleClass.kt")
        public void testSimpleClass() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/simpleClass.kt");
        }

        @Test
        @TestMetadata("simpleFun.kt")
        public void testSimpleFun() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/simpleFun.kt");
        }

        @Test
        @TestMetadata("simpleTypeAlias.kt")
        public void testSimpleTypeAlias() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/simpleTypeAlias.kt");
        }

        @Test
        @TestMetadata("splitModifierList.kt")
        public void testSplitModifierList() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/splitModifierList.kt");
        }

        @Test
        @TestMetadata("suspendFunctionTypes.kt")
        public void testSuspendFunctionTypes() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/suspendFunctionTypes.kt");
        }

        @Test
        @TestMetadata("typeAliasWithGeneric.kt")
        public void testTypeAliasWithGeneric() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/typeAliasWithGeneric.kt");
        }

        @Test
        @TestMetadata("typeParameterVsNested.kt")
        public void testTypeParameterVsNested() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/typeParameterVsNested.kt");
        }

        @Test
        @TestMetadata("typeParameters.kt")
        public void testTypeParameters() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/typeParameters.kt");
        }

        @Test
        @TestMetadata("where.kt")
        public void testWhere() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/where.kt");
        }

        @Nested
        @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts")
        @TestDataPath("$PROJECT_ROOT")
        public class Contracts {
            @Test
            public void testAllFilesPresentInContracts() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts"), Pattern.compile("^(.+)\\.kt$"), null, true);
            }

            @Nested
            @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax")
            @TestDataPath("$PROJECT_ROOT")
            public class NewSyntax {
                @Test
                public void testAllFilesPresentInNewSyntax() throws Exception {
                    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax"), Pattern.compile("^(.+)\\.kt$"), null, true);
                }

                @Test
                @TestMetadata("functionWithBothOldAndNewSyntaxContractDescription.kt")
                public void testFunctionWithBothOldAndNewSyntaxContractDescription() throws Exception {
                    runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax/functionWithBothOldAndNewSyntaxContractDescription.kt");
                }

                @Test
                @TestMetadata("propertyAccessorsContractDescription.kt")
                public void testPropertyAccessorsContractDescription() throws Exception {
                    runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax/propertyAccessorsContractDescription.kt");
                }

                @Test
                @TestMetadata("simpleFunctionsContractDescription.kt")
                public void testSimpleFunctionsContractDescription() throws Exception {
                    runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/newSyntax/simpleFunctionsContractDescription.kt");
                }
            }

            @Nested
            @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/oldSyntax")
            @TestDataPath("$PROJECT_ROOT")
            public class OldSyntax {
                @Test
                public void testAllFilesPresentInOldSyntax() throws Exception {
                    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/oldSyntax"), Pattern.compile("^(.+)\\.kt$"), null, true);
                }

                @Test
                @TestMetadata("contractDescription.kt")
                public void testContractDescription() throws Exception {
                    runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/declarations/contracts/oldSyntax/contractDescription.kt");
                }
            }
        }
    }

    @Nested
    @TestMetadata("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions")
    @TestDataPath("$PROJECT_ROOT")
    public class Expressions {
        @Test
        public void testAllFilesPresentInExpressions() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("annotated.kt")
        public void testAnnotated() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/annotated.kt");
        }

        @Test
        @TestMetadata("arrayAccess.kt")
        public void testArrayAccess() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/arrayAccess.kt");
        }

        @Test
        @TestMetadata("arrayAssignment.kt")
        public void testArrayAssignment() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/arrayAssignment.kt");
        }

        @Test
        @TestMetadata("branches.kt")
        public void testBranches() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/branches.kt");
        }

        @Test
        @TestMetadata("callableReferences.kt")
        public void testCallableReferences() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/callableReferences.kt");
        }

        @Test
        @TestMetadata("calls.kt")
        public void testCalls() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/calls.kt");
        }

        @Test
        @TestMetadata("cascadeIf.kt")
        public void testCascadeIf() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/cascadeIf.kt");
        }

        @Test
        @TestMetadata("classReference.kt")
        public void testClassReference() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/classReference.kt");
        }

        @Test
        @TestMetadata("collectionLiterals.kt")
        public void testCollectionLiterals() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/collectionLiterals.kt");
        }

        @Test
        @TestMetadata("destructuring.kt")
        public void testDestructuring() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/destructuring.kt");
        }

        @Test
        @TestMetadata("for.kt")
        public void testFor() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/for.kt");
        }

        @Test
        @TestMetadata("genericCalls.kt")
        public void testGenericCalls() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/genericCalls.kt");
        }

        @Test
        @TestMetadata("in.kt")
        public void testIn() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/in.kt");
        }

        @Test
        @TestMetadata("inBrackets.kt")
        public void testInBrackets() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/inBrackets.kt");
        }

        @Test
        @TestMetadata("init.kt")
        public void testInit() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/init.kt");
        }

        @Test
        @TestMetadata("labelForInfix.kt")
        public void testLabelForInfix() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/labelForInfix.kt");
        }

        @Test
        @TestMetadata("lambda.kt")
        public void testLambda() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/lambda.kt");
        }

        @Test
        @TestMetadata("lambdaAndAnonymousFunction.kt")
        public void testLambdaAndAnonymousFunction() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/lambdaAndAnonymousFunction.kt");
        }

        @Test
        @TestMetadata("localDeclarationWithExpression.kt")
        public void testLocalDeclarationWithExpression() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/localDeclarationWithExpression.kt");
        }

        @Test
        @TestMetadata("locals.kt")
        public void testLocals() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/locals.kt");
        }

        @Test
        @TestMetadata("modifications.kt")
        public void testModifications() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/modifications.kt");
        }

        @Test
        @TestMetadata("namedArgument.kt")
        public void testNamedArgument() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/namedArgument.kt");
        }

        @Test
        @TestMetadata("nullability.kt")
        public void testNullability() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/nullability.kt");
        }

        @Test
        @TestMetadata("qualifierWithTypeArguments.kt")
        public void testQualifierWithTypeArguments() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/qualifierWithTypeArguments.kt");
        }

        @Test
        @TestMetadata("safeCallsWithAssignment.kt")
        public void testSafeCallsWithAssignment() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/safeCallsWithAssignment.kt");
        }

        @Test
        @TestMetadata("safeCallsWithAugmentedAssignment.kt")
        public void testSafeCallsWithAugmentedAssignment() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/safeCallsWithAugmentedAssignment.kt");
        }

        @Test
        @TestMetadata("safeCallsWithUnaryOperators.kt")
        public void testSafeCallsWithUnaryOperators() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/safeCallsWithUnaryOperators.kt");
        }

        @Test
        @TestMetadata("simpleReturns.kt")
        public void testSimpleReturns() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/simpleReturns.kt");
        }

        @Test
        @TestMetadata("super.kt")
        public void testSuper() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/super.kt");
        }

        @Test
        @TestMetadata("these.kt")
        public void testThese() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/these.kt");
        }

        @Test
        @TestMetadata("try.kt")
        public void testTry() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/try.kt");
        }

        @Test
        @TestMetadata("typeOperators.kt")
        public void testTypeOperators() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/typeOperators.kt");
        }

        @Test
        @TestMetadata("unary.kt")
        public void testUnary() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/unary.kt");
        }

        @Test
        @TestMetadata("variables.kt")
        public void testVariables() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/variables.kt");
        }

        @Test
        @TestMetadata("while.kt")
        public void testWhile() throws Exception {
            runTest("compiler/fir/raw-fir/psi2fir/testData/rawBuilder/expressions/while.kt");
        }
    }
}
