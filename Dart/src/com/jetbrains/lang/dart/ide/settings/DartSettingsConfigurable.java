package com.jetbrains.lang.dart.ide.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import com.jetbrains.lang.dart.DartBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DartSettingsConfigurable implements SearchableConfigurable, Configurable.NoScroll {
  private DartSettingsUI mySettingsUI;
  private Project myProject;

  public DartSettingsConfigurable(Project project) {
    myProject = project;
  }

  @Nls
  @Override
  public String getDisplayName() {
    return DartBundle.message("dart.title");
  }

  @Override
  public String getHelpTopic() {
    return "settings.dart.settings";
  }

  @NotNull
  private DartSettingsUI getSettingsUI() {
    if (mySettingsUI == null) {
      mySettingsUI = new DartSettingsUI(myProject);
    }
    return mySettingsUI;
  }

  @Override
  public JComponent createComponent() {
    return getSettingsUI().getMainPanel();
  }

  @Override
  public boolean isModified() {
    final DartSettings dartSettings = getSettingsUI().getSettings();
    return !DartSettings.getSettings().equals(dartSettings);
  }

  @Override
  public void apply() throws ConfigurationException {
    getSettingsUI().updateOrCreateDartLibrary();
    DartSettingsUtil.setSettings(getSettingsUI().getSettings());
    reset();
  }

  @Override
  public void reset() {
    final DartSettings dartSettings = DartSettings.getSettings();
    getSettingsUI().setSettings(dartSettings);
  }

  @Override
  public void disposeUIResources() {
  }

  @NotNull
  @Override
  public String getId() {
    return "dart.settings";
  }

  @Nullable
  @Override
  public Runnable enableSearch(String option) {
    return null;
  }
}
