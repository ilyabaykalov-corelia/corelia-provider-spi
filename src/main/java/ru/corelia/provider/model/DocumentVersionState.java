package ru.corelia.provider.model;

import java.util.List;

/** Согласованное состояние документа, его текущей версии и состава вложений. */
public record DocumentVersionState(DocumentSnapshot document, DocumentVersion currentVersion,
                                   List<DocumentVersion> versions, List<AttachmentMetadata> attachments) {
    public DocumentVersionState {
        versions = List.copyOf(versions);
        attachments = List.copyOf(attachments);
    }
}
