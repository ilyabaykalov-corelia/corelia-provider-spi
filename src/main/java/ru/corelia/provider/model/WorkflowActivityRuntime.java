package ru.corelia.provider.model;

/** Текущее количество активных экземпляров на BPMN activity. */
public record WorkflowActivityRuntime(String activityId, long activeInstances) {}
