package ru.corelia.provider.model;

import java.util.List;

/** Согласованное состояние документа, его текущей версии и состава вложений.
 * @param document актуальный snapshot документа
 * @param currentVersion текущая зафиксированная версия
 * @param versions история версий
 * @param attachments состав текущей версии
 */
public record DocumentVersionState(DocumentSnapshot document, DocumentVersion currentVersion,
                                   List<DocumentVersion> versions, List<AttachmentMetadata> attachments) {
    public DocumentVersionState {
        versions = List.copyOf(versions);
        attachments = List.copyOf(attachments);
    }
}
