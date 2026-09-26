package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.DocumentSearchRequest;
import ru.corelia.provider.model.DocumentSearchResult;
import ru.corelia.provider.model.DocumentCreation;
import ru.corelia.provider.model.DocumentSnapshot;

/** Возможность хранения и чтения актуальных документов. */
public interface DocumentStore {
    /**
     * Создаёт документ от имени авторизованного пользователя.
     * Реализация должна проверять права и не создавать вторую сущность при повторе
     * одной идемпотентной команды, если такая семантика обеспечивается provider.
     */
    void create(DocumentCreation creation, AuthContext auth);
    /** Возвращает только документы, доступные {@code auth}, с применением pagination из запроса. */
    DocumentSearchResult search(DocumentSearchRequest request, AuthContext auth);
    /** Возвращает актуальный snapshot документа или сообщает provider-ошибку отсутствия/доступа. */
    DocumentSnapshot get(String typeCode, String documentId, AuthContext auth);
}
