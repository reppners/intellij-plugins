package org.osmorc.frameworkintegration.impl;

import com.intellij.openapi.util.io.JarUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.ObjectUtils;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osmorc.frameworkintegration.CachingBundleInfoProvider;
import org.osmorc.frameworkintegration.FrameworkInstanceDefinition;
import org.osmorc.frameworkintegration.FrameworkInstanceManager;
import org.osmorc.util.OsgiFileUtil;
import org.osmorc.i18n.OsmorcBundle;
import org.osmorc.run.ui.SelectedBundle;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Base class for all {@link org.osmorc.frameworkintegration.FrameworkInstanceManager}s.
 */
public abstract class AbstractFrameworkInstanceManager implements FrameworkInstanceManager {
  @Nullable
  public String getVersion(@NotNull FrameworkInstanceDefinition instance) {
    Collection<SelectedBundle> bundles = getFrameworkBundles(instance, FrameworkBundleType.SYSTEM);
    if (bundles.size() == 1) {
      SelectedBundle bundle = bundles.iterator().next();
      return CachingBundleInfoProvider.getBundleVersion(bundle.getBundleUrl());
    }

    return null;
  }

  @Nullable
  @Override
  public String checkValidity(@NotNull FrameworkInstanceDefinition instance) {
    String basePath = instance.getBaseFolder();
    if (basePath == null || !new File(basePath).isDirectory()) {
      return OsmorcBundle.message("framework.directory.missing", (basePath != null ? basePath : ""), instance.getFrameworkIntegratorName());
    }

    String version = getVersion(instance);
    if (version == null) {
      return OsmorcBundle.message("framework.jar.missing", basePath, instance.getFrameworkIntegratorName());
    }

    if (StringUtil.isEmptyOrSpaces(instance.getName())) {
      return OsmorcBundle.message("framework.name.missing");
    }

    return null;
  }

  @NotNull
  protected Collection<SelectedBundle> collectBundles(@NotNull FrameworkInstanceDefinition instance,
                                                      @NotNull FrameworkBundleType type,
                                                      @NotNull String[] bundleDirs,
                                                      @NotNull Pattern sysNamePattern,
                                                      @Nullable String sysControlClass,
                                                      int sysExpected,
                                                      @Nullable Pattern shellNamePattern,
                                                      @Nullable String shellControlClass,
                                                      int shellExpected) {
    String basePath = instance.getBaseFolder();
    if (basePath == null || !new File(basePath).isDirectory()) {
      return ContainerUtil.emptyList();
    }

    int expected = type == FrameworkBundleType.SYSTEM ? sysExpected : type == FrameworkBundleType.SHELL ? shellExpected : -1;
    if (expected == 0) return ContainerUtil.emptyList();

    Collection<SelectedBundle> bundles = ContainerUtil.newArrayList();

    outer:
    for (File dir : flattenDirPatterns(basePath, bundleDirs)) {
      File[] files = ObjectUtils.notNull(dir.listFiles(), ArrayUtil.EMPTY_FILE_ARRAY);
      for (File file : files) {
        FrameworkBundleType bundleType = detectType(file, sysNamePattern, sysControlClass, shellNamePattern, shellControlClass);
        if (bundleType == type) {
          SelectedBundle bundle = makeBundle(file);
          bundles.add(bundle);
          if (expected > 0 && bundles.size() == expected) {
            break outer;
          }
        }
      }
    }

    if (expected > 0 && bundles.size() < expected) {
      return Collections.emptyList();
    }

    return bundles;
  }

  protected List<File> flattenDirPatterns(String basePath, String[] bundleDirs) {
    List<File> dirs = ContainerUtil.newArrayList();
    for (String subDir : bundleDirs) {
      if (subDir.isEmpty()) {
        dirs.add(new File(basePath));
      }
      else if (subDir.endsWith("/*")) {
        File[] nestedDirs = new File(basePath, subDir.substring(0, subDir.length() - 2)).listFiles();
        if (nestedDirs != null) {
          ContainerUtil.addAll(dirs, nestedDirs);
        }
      }
      else {
        dirs.add(new File(basePath, subDir));
      }
    }
    return dirs;
  }

  protected FrameworkBundleType detectType(File file, Pattern sysPattern, String sysClass, Pattern shellPattern, String shellClass) {
    FrameworkBundleType bundleType = null;

    String name = file.getName();
    if (name.endsWith(".jar") && JarUtil.containsEntry(file, "META-INF/MANIFEST.MF")) {
      if (sysPattern.matcher(name).matches() && (sysClass == null || JarUtil.containsClass(file, sysClass))) {
        bundleType = FrameworkBundleType.SYSTEM;
      }
      else if (shellPattern != null && shellPattern.matcher(name).matches() &&
               (shellClass == null || JarUtil.containsClass(file, shellClass))) {
        bundleType = FrameworkBundleType.SHELL;
      }
      else if (CachingBundleInfoProvider.isBundle(OsgiFileUtil.pathToUrl(file.getPath()))) {
        bundleType = FrameworkBundleType.OTHER;
      }
    }

    return bundleType;
  }

  protected SelectedBundle makeBundle(File file) {
    String url = OsgiFileUtil.pathToUrl(file.getPath());

    String bundleName = CachingBundleInfoProvider.getBundleSymbolicName(url);
    if (bundleName != null) {
      String bundleVersion = CachingBundleInfoProvider.getBundleVersion(url);
      if (bundleVersion != null) {
        bundleName += " - " + bundleVersion;
      }
    }
    else {
      bundleName = file.getName();
    }

    return new SelectedBundle(bundleName, url, SelectedBundle.BundleType.FrameworkBundle);
  }
}
