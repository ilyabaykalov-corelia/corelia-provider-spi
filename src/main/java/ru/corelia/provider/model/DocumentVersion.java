package ru.corelia.provider.model;

import java.time.Instant;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Канонический зафиксированный вариант документа. */
public record DocumentVersion(String documentId, int number, Map<String, JsonNode> attributes,
                              String status, Instant createdAt, String createdBy) {
    public DocumentVersion { attributes = Map.copyOf(attributes); }
}
