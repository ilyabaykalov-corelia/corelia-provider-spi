package ru.corelia.provider.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Канонический зафиксированный вариант документа. */
public record DocumentVersion(String id, String documentId, int number, int schemaVersion, Map<String, JsonNode> attributes,
                              String status, Instant createdAt, String createdBy, Instant closedAt, List<AttachmentMetadata> attachments) {
    public DocumentVersion { attributes = Map.copyOf(attributes); attachments = List.copyOf(attachments); }
}
