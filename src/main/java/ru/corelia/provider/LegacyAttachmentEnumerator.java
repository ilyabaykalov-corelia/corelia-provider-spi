package ru.corelia.provider;

import java.util.List;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AttachmentMetadata;

/** Временный источник historical attachment metadata для контролируемой миграции. */
public interface LegacyAttachmentEnumerator {
    /**
     * Возвращает только доступные вызывающему записи, которые ещё требуют
     * миграции ссылки. Результат не является текущим каталогом вложений.
     */
    List<AttachmentMetadata> historicalAttachments(AuthContext auth);
}
