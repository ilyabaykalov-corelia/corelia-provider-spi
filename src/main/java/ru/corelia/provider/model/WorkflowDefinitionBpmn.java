package ru.corelia.provider.model;

/** BPMN опубликованного provider-ом процесса для просмотра без технических DTO. */
public record WorkflowDefinitionBpmn(String key, String name, String bpmnXml) {}
