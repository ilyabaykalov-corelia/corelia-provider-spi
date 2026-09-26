package ru.corelia.provider.model;

import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Атомарное изменение версии документа, независимое от модели хранилища провайдера. */
public record DocumentMutation(String documentId, String documentType, int expectedVersion, String expectedChangeToken,
                               Map<String, JsonNode> attributes, DocumentVersion createdVersion,
                               DocumentVersion closedVersion, AttachmentMetadata createdAttachment,
                               AttachmentMetadata retiredAttachment, String idempotencyKey,
                               String requestHash, JsonNode response, JsonNode history) {
    public DocumentMutation { attributes = Map.copyOf(attributes); }
    public DocumentMutation(String documentId, String documentType, int expectedVersion, String expectedChangeToken,
                            Map<String, JsonNode> attributes, DocumentVersion createdVersion, DocumentVersion closedVersion,
                            AttachmentMetadata createdAttachment, AttachmentMetadata retiredAttachment, String idempotencyKey,
                            String requestHash, JsonNode response) {
        this(documentId, documentType, expectedVersion, expectedChangeToken, attributes, createdVersion, closedVersion,
                createdAttachment, retiredAttachment, idempotencyKey, requestHash, response, null);
    }
}
