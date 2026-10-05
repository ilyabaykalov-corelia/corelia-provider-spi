package ru.corelia.provider.model;

/** BPMN опубликованного provider-ом процесса вместе с identity его версии. */
public record WorkflowDefinitionBpmn(String key, String name, String bpmnXml, int publishedVersion,
                                     String definitionId, String deploymentId) {}
