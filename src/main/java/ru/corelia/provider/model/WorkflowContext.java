package ru.corelia.provider.model;

import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Семантические данные запуска процесса без tenant и provider payload.
 * @param documentId документ процесса
 * @param documentType тип документа
 * @param attributes реквизиты
 * @param createdBy пользователь-инициатор
 * @param externalBusinessKey внешний ключ процесса
 * @param initialAttachment обязательный первый файл
 * @param creationKey ключ идемпотентного создания
 * @param creationHash hash исходной команды
 */
public record WorkflowContext(String documentId, String documentType, Map<String, JsonNode> attributes,
                              String createdBy, String externalBusinessKey, AttachmentMetadata initialAttachment,
                              String creationKey, String creationHash) {
    public WorkflowContext { attributes = Map.copyOf(attributes); }
}
