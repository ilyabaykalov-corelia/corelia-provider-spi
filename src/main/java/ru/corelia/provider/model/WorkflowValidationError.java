package ru.corelia.provider.model;

/** Диагностика проверки BPMN-черновика без раскрытия деталей workflow provider. */
public record WorkflowValidationError(String code, String message) { }
