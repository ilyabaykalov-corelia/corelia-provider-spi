package ru.corelia.provider.model;

/** Канонические состояния задач workflow, используемые Corelia независимо от provider-а. */
public enum TaskStatus {
    NEW,
    ASSIGNED,
    STARTED,
    COMPLETED,
    ABORTED;

    /** Нормализует распространённые обозначения состояния внешнего workflow provider-а. */
    public static TaskStatus fromProvider(String value) {
        return switch (value == null ? "" : value.trim().toUpperCase(java.util.Locale.ROOT)) {
            case "NEW", "CREATED", "OPEN" -> NEW;
            case "ASSIGNED", "QUEUED" -> ASSIGNED;
            case "STARTED", "IN_PROGRESS", "IN_WORK", "ACTIVE" -> STARTED;
            case "COMPLETED", "DONE", "CLOSED", "SUCCESS" -> COMPLETED;
            case "ABORTED", "CANCELLED", "CANCELED", "FAILED" -> ABORTED;
            default -> throw new IllegalArgumentException("Неизвестный статус задачи provider-а: " + value);
        };
    }
}
