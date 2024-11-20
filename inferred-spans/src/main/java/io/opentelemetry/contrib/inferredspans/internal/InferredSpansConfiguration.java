/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.contrib.inferredspans.internal;

import io.opentelemetry.contrib.inferredspans.ParentOverrideHandler;
import io.opentelemetry.contrib.inferredspans.WildcardMatcher;
import java.time.Duration;
import java.util.List;
import javax.annotation.Nullable;

public class InferredSpansConfiguration {

  private final boolean profilerLoggingEnabled;
  private final boolean backupDiagnosticFiles;
  private final int asyncProfilerSafeMode;
  private final boolean postProcessingEnabled;
  private final Duration samplingInterval;
  private final Duration inferredSpansMinDuration;
  private final List<WildcardMatcher> includedClasses;
  private final List<WildcardMatcher> excludedClasses;
  private final Duration profilerInterval;
  private final Duration profilingDuration;
  @Nullable private final String profilerLibDirectory;
  private final ParentOverrideHandler parentOverrideHandler;

  @SuppressWarnings("TooManyParameters")
  public InferredSpansConfiguration(
      boolean profilerLoggingEnabled,
      boolean backupDiagnosticFiles,
      int asyncProfilerSafeMode,
      boolean postProcessingEnabled,
      Duration samplingInterval,
      Duration inferredSpansMinDuration,
      List<WildcardMatcher> includedClasses,
      List<WildcardMatcher> excludedClasses,
      Duration profilerInterval,
      Duration profilingDuration,
      @Nullable String profilerLibDirectory,
      ParentOverrideHandler parentOverrideHandler) {
    this.profilerLoggingEnabled = profilerLoggingEnabled;
    this.backupDiagnosticFiles = backupDiagnosticFiles;
    this.asyncProfilerSafeMode = asyncProfilerSafeMode;
    this.postProcessingEnabled = postProcessingEnabled;
    this.samplingInterval = samplingInterval;
    this.inferredSpansMinDuration = inferredSpansMinDuration;
    this.includedClasses = includedClasses;
    this.excludedClasses = excludedClasses;
    this.profilerInterval = profilerInterval;
    this.profilingDuration = profilingDuration;
    this.profilerLibDirectory = profilerLibDirectory;
    this.parentOverrideHandler = parentOverrideHandler;
  }

  public boolean isProfilingLoggingEnabled() {
    return profilerLoggingEnabled;
  }

  public int getAsyncProfilerSafeMode() {
    return asyncProfilerSafeMode;
  }

  public Duration getSamplingInterval() {
    return samplingInterval;
  }

  public Duration getInferredSpansMinDuration() {
    return inferredSpansMinDuration;
  }

  public List<WildcardMatcher> getIncludedClasses() {
    return includedClasses;
  }

  public List<WildcardMatcher> getExcludedClasses() {
    return excludedClasses;
  }

  public Duration getProfilingInterval() {
    return profilerInterval;
  }

  public Duration getProfilingDuration() {
    return profilingDuration;
  }

  public boolean isNonStopProfiling() {
    return getProfilingDuration().toMillis() >= getProfilingInterval().toMillis();
  }

  public boolean isBackupDiagnosticFiles() {
    return backupDiagnosticFiles;
  }

  public String getProfilerLibDirectory() {
    return profilerLibDirectory == null || profilerLibDirectory.isEmpty()
        ? System.getProperty("java.io.tmpdir")
        : profilerLibDirectory;
  }

  public boolean isPostProcessingEnabled() {
    return postProcessingEnabled;
  }

  public ParentOverrideHandler getParentOverrideHandler() {
    return parentOverrideHandler;
  }
}
