package io.opentelemetry.contrib.inferredspans;

import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;

@FunctionalInterface
public interface ParentOverrideHandler {

  void setParent(SpanBuilder spanBuilder, SpanContext spanContext);
}
