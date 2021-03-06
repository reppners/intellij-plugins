// This is a generated file. Not intended for manual editing.
package com.jetbrains.lang.dart.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DartDoWhileStatement extends DartPsiCompositeElement {

  @Nullable
  DartAssertStatement getAssertStatement();

  @Nullable
  DartBlock getBlock();

  @Nullable
  DartBreakStatement getBreakStatement();

  @Nullable
  DartContinueStatement getContinueStatement();

  @Nullable
  DartDoWhileStatement getDoWhileStatement();

  @NotNull
  List<DartExpression> getExpressionList();

  @Nullable
  DartForStatement getForStatement();

  @Nullable
  DartFunctionDeclarationWithBody getFunctionDeclarationWithBody();

  @Nullable
  DartIfStatement getIfStatement();

  @NotNull
  List<DartLabel> getLabelList();

  @NotNull
  List<DartMetadata> getMetadataList();

  @Nullable
  DartRethrowStatement getRethrowStatement();

  @Nullable
  DartReturnStatement getReturnStatement();

  @Nullable
  DartSwitchStatement getSwitchStatement();

  @Nullable
  DartThrowStatement getThrowStatement();

  @Nullable
  DartTryStatement getTryStatement();

  @Nullable
  DartVarDeclarationList getVarDeclarationList();

  @Nullable
  DartWhileStatement getWhileStatement();

}
