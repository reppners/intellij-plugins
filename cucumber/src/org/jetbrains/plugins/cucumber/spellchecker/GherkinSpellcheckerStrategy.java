package org.jetbrains.plugins.cucumber.spellchecker;

import com.intellij.codeInspection.SuppressIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.SuppressibleSpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.cucumber.inspections.suppress.GherkinSuppressionUtil;
import org.jetbrains.plugins.cucumber.psi.GherkinElementType;

/**
 * @author oleg
 */
public class GherkinSpellcheckerStrategy extends SuppressibleSpellcheckingStrategy {
  @NotNull
  @Override
  public Tokenizer getTokenizer(final PsiElement element) {
    if (element instanceof LeafElement) {
      final ASTNode node = element.getNode();
      if (node != null && node.getElementType() instanceof GherkinElementType){
        return SpellcheckingStrategy.TEXT_TOKENIZER;
      }
    }
    return super.getTokenizer(element);
  }

  @Override
  public boolean isSuppressedFor(PsiElement element, String name) {
    return GherkinSuppressionUtil.isSuppressedFor(element, name);
  }

  @Override
  public SuppressIntentionAction[] getSuppressActions(final PsiElement element, final String name) {
    return GherkinSuppressionUtil.getDefaultSuppressActions(element, name);
  }
}