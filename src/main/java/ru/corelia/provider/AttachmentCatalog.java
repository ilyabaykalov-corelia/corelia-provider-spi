package ru.corelia.provider;

import java.util.List;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;

/** Возможность находить metadata вложений и их историю. */
public interface AttachmentCatalog {
    /** Находит metadata запрошенного вложения с проверкой доступа. */
    AttachmentMetadata find(String attachmentId, AuthContext auth);
    /** Возвращает историю версий logical attachment, а не только текущую версию. */
    List<AttachmentMetadata> attachmentVersions(String attachmentId, AuthContext auth);
}
