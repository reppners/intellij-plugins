// This is a generated file. Not intended for manual editing.
package com.jetbrains.lang.dart.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DartImportStatement extends DartPsiCompositeElement {

  @Nullable
  DartComponentName getComponentName();

  @NotNull
  List<DartHideCombinator> getHideCombinatorList();

  @NotNull
  List<DartMetadata> getMetadataList();

  @NotNull
  DartPathOrLibraryReference getPathOrLibraryReference();

  @NotNull
  List<DartShowCombinator> getShowCombinatorList();

  @NotNull
  String getLibraryName();

  @NotNull
  DartPathOrLibraryReference getLibraryExpression();

  @Nullable
  PsiElement getLibraryPrefix();

}
