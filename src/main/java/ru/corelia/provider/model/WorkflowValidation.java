package ru.corelia.provider.model;

import java.util.List;

/** Результат проверки BPMN-определения выбранным workflow provider. */
public record WorkflowValidation(List<WorkflowValidationError> errors) {
    public boolean valid() { return errors.isEmpty(); }
}
