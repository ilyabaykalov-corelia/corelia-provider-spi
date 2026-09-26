package ru.corelia.provider.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Канонический зафиксированный вариант документа.
 * @param id идентификатор версии
 * @param documentId документ-владелец
 * @param number последовательный номер
 * @param schemaVersion версия схемы
 * @param attributes snapshot реквизитов
 * @param status статус на момент фиксации
 * @param createdAt время создания
 * @param createdBy автор
 * @param closedAt время закрытия
 * @param attachments состав вложений
 */
public record DocumentVersion(String id, String documentId, int number, int schemaVersion, Map<String, JsonNode> attributes,
                              String status, Instant createdAt, String createdBy, Instant closedAt, List<AttachmentMetadata> attachments) {
    public DocumentVersion { attributes = Map.copyOf(attributes); attachments = List.copyOf(attachments); }
}
