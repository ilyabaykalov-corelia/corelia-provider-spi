package ru.corelia.provider.model;

import java.util.List;

/** Каноническая задача процесса. */
public record WorkflowTask(String id, String documentId, String documentType, String status,
                           String assignee, List<WorkflowAction> actions) {
    public WorkflowTask { actions = List.copyOf(actions); }
}
