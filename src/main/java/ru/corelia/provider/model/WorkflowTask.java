package ru.corelia.provider.model;

import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Каноническая задача процесса. */
public record WorkflowTask(String id, String documentId, String documentType, String status,
                           String assignee, String assigneeName, String assigneeRole, String title,
                           String description, Map<String, JsonNode> attributes, List<WorkflowAction> actions) {
    public WorkflowTask { attributes = Map.copyOf(attributes); actions = List.copyOf(actions); }
}
