package com.dmarcotte.handlebars.file;

import com.dmarcotte.handlebars.HbLanguage;
import com.dmarcotte.handlebars.parsing.HbTokenTypes;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.ConfigurableTemplateLanguageFileViewProvider;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Set;

public class HbFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider
  implements ConfigurableTemplateLanguageFileViewProvider {

  private final Language myBaseLanguage;
  private final Language myTemplateLanguage;

  private static final TemplateDataElementType TEMPLATE_DATA_ELEMENT_TYPE =
    new TemplateDataElementType("HB_TEMPLATE_DATA", HbLanguage.INSTANCE, HbTokenTypes.CONTENT, HbTokenTypes.OUTER_ELEMENT_TYPE);

  public HbFileViewProvider(PsiManager manager, VirtualFile file, boolean physical, Language baseLanguage) {
    this(manager, file, physical, baseLanguage, getTemplateDataLanguage(manager, file));
  }

  public HbFileViewProvider(PsiManager manager, VirtualFile file, boolean physical, Language baseLanguage, Language templateLanguage) {
    super(manager, file, physical);
    myBaseLanguage = baseLanguage;
    myTemplateLanguage = templateLanguage;
  }

  @Override
  public boolean supportsIncrementalReparse(@NotNull Language rootLanguage) {
    return false;
  }

  @NotNull
  private static Language getTemplateDataLanguage(PsiManager manager, VirtualFile file) {
    Language dataLang = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
    if (dataLang == null) {
      dataLang = HbLanguage.getDefaultTemplateLang().getLanguage();
    }

    Language substituteLang = LanguageSubstitutors.INSTANCE.substituteLanguage(dataLang, file, manager.getProject());

    // only use a substituted language if it's templateable
    if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLang)) {
      dataLang = substituteLang;
    }

    return dataLang;
  }

  @NotNull
  @Override
  public Language getBaseLanguage() {
    return myBaseLanguage;
  }

  @NotNull
  @Override
  public Language getTemplateDataLanguage() {
    return myTemplateLanguage;
  }

  @NotNull
  @Override
  public Set<Language> getLanguages() {
    return new THashSet<Language>(Arrays.asList(new Language[]{HbLanguage.INSTANCE, myBaseLanguage, getTemplateDataLanguage()}));
  }

  @Override
  protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile virtualFile) {
    return new HbFileViewProvider(getManager(), virtualFile, false, myBaseLanguage, myTemplateLanguage);
  }

  @Override
  protected PsiFile createFile(@NotNull Language lang) {
    ParserDefinition parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(lang);
    if (parserDefinition == null) {
      return null;
    }

    if (lang == getTemplateDataLanguage()) {
      PsiFileImpl file = (PsiFileImpl)parserDefinition.createFile(this);
      file.setContentElementType(TEMPLATE_DATA_ELEMENT_TYPE);
      return file;
    }
    else if (lang == HbLanguage.INSTANCE) {
      return parserDefinition.createFile(this);
    }
    else {
      return null;
    }
  }
}

