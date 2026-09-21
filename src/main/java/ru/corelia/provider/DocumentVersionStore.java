package ru.corelia.provider;

import java.util.List;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;
import ru.corelia.provider.model.DocumentVersion;

/** Возможность чтения зафиксированных версий документа и вложений. */
public interface DocumentVersionStore {
    List<DocumentVersion> versions(String documentId, AuthContext auth);
    List<AttachmentMetadata> attachments(String documentId, AuthContext auth);
}
