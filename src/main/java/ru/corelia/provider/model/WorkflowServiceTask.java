package ru.corelia.provider.model;

/** Контекст provider-neutral команды, запущенной из BPMN service task. */
public record WorkflowServiceTask(
        String taskType,
        String taskId,
        String executionId,
        String processInstanceId,
        String documentId,
        String documentType,
        String command) { }
