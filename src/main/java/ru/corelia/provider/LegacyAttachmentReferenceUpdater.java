package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;
import ru.corelia.provider.model.StorageReference;

/** Временная capability для условной замены legacy binary reference во время миграции. */
public interface LegacyAttachmentReferenceUpdater {
    /**
     * Заменяет ссылку только если она по-прежнему равна {@code expectedReference}.
     * Реализация должна сообщить конфликт вместо перезаписи более новой миграции.
     */
    void replaceStorageReference(
            AttachmentMetadata attachment,
            StorageReference expectedReference,
            StorageReference replacementReference,
            AuthContext auth);
}
