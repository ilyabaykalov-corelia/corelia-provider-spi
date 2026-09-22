package ru.corelia.provider;

import java.util.List;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;

/** Возможность находить metadata вложений и их историю. */
public interface AttachmentCatalog {
    AttachmentMetadata find(String attachmentId, AuthContext auth);
    List<AttachmentMetadata> attachmentVersions(String attachmentId, AuthContext auth);
}
