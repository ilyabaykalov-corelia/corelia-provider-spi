package ru.corelia.provider.model;

import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Допустимое действие канонической задачи. */
public record WorkflowAction(String code, String label, String status, String tone, Map<String, JsonNode> parameters) {
    public WorkflowAction { parameters = Map.copyOf(parameters); }
}
