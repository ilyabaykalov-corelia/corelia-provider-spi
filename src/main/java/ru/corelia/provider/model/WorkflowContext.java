package ru.corelia.provider.model;

import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Семантические данные запуска процесса без tenant и provider payload. */
public record WorkflowContext(String documentId, String documentType, Map<String, JsonNode> attributes,
                              String createdBy, String externalBusinessKey) {
    public WorkflowContext { attributes = Map.copyOf(attributes); }
}
