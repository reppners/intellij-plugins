package com.jetbrains.lang.dart.analyzer;

import com.google.dart.engine.context.AnalysisContext;
import com.google.dart.engine.error.AnalysisError;
import com.intellij.codeInsight.daemon.impl.AnnotationHolderImpl;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationSession;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.testFramework.fixtures.CodeInsightFixtureTestCase;
import com.intellij.util.ArrayUtil;
import com.intellij.util.containers.ContainerUtil;
import com.jetbrains.lang.dart.ide.settings.DartSettings;
import com.jetbrains.lang.dart.ide.settings.DartSettingsUtil;
import com.jetbrains.lang.dart.util.DartTestUtils;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

abstract public class DartAnalyzerTestBase extends CodeInsightFixtureTestCase {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    final DartSettings settings = getDartSettings();
    DartSettingsUtil.setSettings(settings);

    System.setProperty(
      "com.google.dart.sdk",
      settings.getSdkPath()
    );
    // todo: hack to remove
    myFixture.setTestDataPath(DartTestUtils.BASE_TEST_DATA_PATH + getBasePath());
  }

  @Override
  public void tearDown() throws Exception {
    super.tearDown();
    System.setProperty("com.google.dart.sdk", "");
  }

  protected DartSettings getDartSettings() {
    return new DartSettings(FileUtil.toSystemDependentName(DartTestUtils.BASE_TEST_DATA_PATH + "/sdk"));
  }

  void doTest(String message, String... additionalFiles) throws IOException {
    doTestWithoutCheck(message, additionalFiles);
    myFixture.checkResultByFile(getTestName(true) + ".after" + getExtension());
  }

  void doTestWithoutCheck(String message, String... additionalFiles) throws IOException {
    final String fullTestName = getTestName(true);
    final int dollarIndex = fullTestName.lastIndexOf('$');
    final String fixSimpleClassName = dollarIndex > 0 ? fullTestName.substring(dollarIndex + 1) : null;
    final String testName = dollarIndex > 0 ? fullTestName.substring(0, dollarIndex) : fullTestName;

    String[] files = ArrayUtil.append(additionalFiles, testName + getExtension());
    files = ArrayUtil.reverseArray(files);

    myFixture.configureByFiles(files);

    final Annotation annotation = doHighlightingAndFindIntention(message);
    assertNotNull("Can't find intention for message: " + message, annotation);

    final List<Annotation.QuickFixInfo> quickFixes = annotation.getQuickFixes();
    assertNotNull("Can't find fixes", quickFixes);
    assertFalse(quickFixes.isEmpty());

    final Annotation.QuickFixInfo quickFixInfo = ContainerUtil.find(quickFixes, new Condition<Annotation.QuickFixInfo>() {
      @Override
      public boolean value(Annotation.QuickFixInfo info) {
        return fixSimpleClassName == null || info.quickFix.getClass().getSimpleName().equals(fixSimpleClassName);
      }
    });
    assertNotNull("Can't find fixes", quickFixInfo);
    assertTrue("Fix not available", quickFixInfo.quickFix.isAvailable(myFixture.getProject(), myFixture.getEditor(), myFixture.getFile()));

    WriteCommandAction.runWriteCommandAction(null, new Runnable() {
      @Override
      public void run() {
        quickFixInfo.quickFix.invoke(myFixture.getProject(), myFixture.getEditor(), myFixture.getFile());
      }
    });
  }

  private String getExtension() {
    return getTestName(true).endsWith("InHtml") ? ".html" : ".dart";
  }

  @Nullable
  private Annotation doHighlightingAndFindIntention(final String message) throws IOException {
    final AnnotationHolderImpl annotationHolder = new AnnotationHolderImpl(new AnnotationSession(myFixture.getFile()));

    final DartInProcessAnnotator annotator = new DartInProcessAnnotator();
    final Pair<DartFileBasedSource, AnalysisContext> information = annotator.collectInformation(myFixture.getFile());
    final AnalysisContext analysisContext = annotator.doAnnotate(information);
    annotator.apply(myFixture.getFile(), analysisContext, annotationHolder);

    return ContainerUtil.find(annotationHolder, new Condition<Annotation>() {
      @Override
      public boolean value(Annotation action) {
        return action.getMessage().startsWith(message);
      }
    });
  }

  protected AnalysisError[] getErrorsFromAnnotator() {
    final DartInProcessAnnotator annotator = new DartInProcessAnnotator();
    final Pair<DartFileBasedSource, AnalysisContext> information = annotator.collectInformation(myFixture.getFile());
    if (information == null) return AnalysisError.NO_ERRORS;
    final AnalysisContext analysisContext = annotator.doAnnotate(information);
    final DartFileBasedSource source = DartFileBasedSource.getSource(getProject(), myFixture.getFile().getVirtualFile());
    return analysisContext == null ? AnalysisError.NO_ERRORS : analysisContext.getErrors(source).getErrors();
  }
}
