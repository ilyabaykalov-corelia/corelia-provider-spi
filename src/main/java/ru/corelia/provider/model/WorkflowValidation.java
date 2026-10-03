package ru.corelia.provider.model;

import java.util.List;

/** Результат проверки BPMN-определения выбранным workflow provider. */
public record WorkflowValidation(List<WorkflowValidationError> errors) {
    /** Возвращает {@code true}, когда provider не сообщил ошибок в BPMN-определении. */
    public boolean valid() { return errors.isEmpty(); }
}
