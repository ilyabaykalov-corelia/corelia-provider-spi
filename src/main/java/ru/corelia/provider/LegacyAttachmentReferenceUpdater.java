package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;
import ru.corelia.provider.model.StorageReference;

/** Временная capability для условной замены legacy binary reference во время миграции. */
public interface LegacyAttachmentReferenceUpdater {
    void replaceStorageReference(
            AttachmentMetadata attachment,
            StorageReference expectedReference,
            StorageReference replacementReference,
            AuthContext auth);
}
