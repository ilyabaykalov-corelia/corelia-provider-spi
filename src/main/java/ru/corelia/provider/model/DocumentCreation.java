package ru.corelia.provider.model;

import java.time.Instant;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Команда создания документа, не зависящая от конкретного хранилища. */
public record DocumentCreation(String documentId, String typeCode, Map<String, JsonNode> attributes,
                               String status, String createdBy, Instant createdAt,
                               AttachmentMetadata initialAttachment, String idempotencyKey,
                               String requestHash, JsonNode history) {
    public DocumentCreation { attributes = Map.copyOf(attributes); }
    public DocumentCreation(String documentId, String typeCode, Map<String, JsonNode> attributes,
                            String status, String createdBy, Instant createdAt, AttachmentMetadata initialAttachment,
                            String idempotencyKey, String requestHash) {
        this(documentId, typeCode, attributes, status, createdBy, createdAt, initialAttachment, idempotencyKey, requestHash, null);
    }
}
