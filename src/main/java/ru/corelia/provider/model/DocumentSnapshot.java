package ru.corelia.provider.model;

import java.time.Instant;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Канонический снимок документа без технического представления провайдера. */
public record DocumentSnapshot(String id, String typeCode, String status, Map<String, JsonNode> attributes,
                               String createdBy, Instant createdAt, String changeToken) {
    public DocumentSnapshot { attributes = Map.copyOf(attributes); }
}
