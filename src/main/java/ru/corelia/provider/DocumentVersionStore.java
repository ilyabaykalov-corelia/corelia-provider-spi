package ru.corelia.provider;

import java.util.List;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;
import ru.corelia.provider.model.DocumentVersion;
import ru.corelia.provider.model.DocumentMutation;
import ru.corelia.provider.model.IdempotencyReceipt;
import ru.corelia.provider.model.DocumentVersionState;

/** Возможность чтения зафиксированных версий документа и вложений. */
public interface DocumentVersionStore {
    String documentType(String documentId, AuthContext auth);
    List<DocumentVersion> documentVersions(String documentId, AuthContext auth);
    List<AttachmentMetadata> attachments(String documentId, AuthContext auth);
    DocumentVersionState state(String documentType, String documentId, AuthContext auth);
    IdempotencyReceipt receipt(String idempotencyKey, AuthContext auth);
    List<tools.jackson.databind.JsonNode> history(String documentId, AuthContext auth);
    void commit(DocumentMutation mutation, AuthContext auth);
}
