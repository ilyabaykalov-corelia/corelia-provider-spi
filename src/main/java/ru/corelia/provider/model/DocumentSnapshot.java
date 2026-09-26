package ru.corelia.provider.model;

import java.time.Instant;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Канонический снимок документа без технического представления провайдера.
 * @param id идентификатор документа
 * @param typeCode тип документа
 * @param status бизнес-статус
 * @param currentVersion номер текущей application-версии
 * @param attributes реквизиты снимка
 * @param createdBy автор создания
 * @param createdAt время создания
 * @param changeToken token optimistic locking
 */
public record DocumentSnapshot(String id, String typeCode, String status, int currentVersion, Map<String, JsonNode> attributes,
                               String createdBy, Instant createdAt, String changeToken) {
    public DocumentSnapshot { attributes = Map.copyOf(attributes); }
}
