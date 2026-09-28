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
    /** Определяет тип документа по его идентификатору с учётом прав вызывающего. */
    String documentType(String documentId, AuthContext auth);
    /** Возвращает неизменяемую историю application-версий в порядке provider. */
    List<DocumentVersion> documentVersions(String documentId, AuthContext auth);
    /** Возвращает metadata вложений текущего snapshot документа. */
    List<AttachmentMetadata> attachments(String documentId, AuthContext auth);
    /**
     * Читает согласованное состояние документа и текущей версии для optimistic locking.
     * Provider не должен собирать части состояния из разных транзакционных snapshots.
     */
    DocumentVersionState state(String documentType, String documentId, AuthContext auth);
    /** Возвращает сохранённый результат идемпотентной команды либо {@code null}, если ключ неизвестен. */
    IdempotencyReceipt receipt(String idempotencyKey, AuthContext auth);
    /** Возвращает audit/history provider в транспортно-независимом JSON-представлении. */
    List<tools.jackson.databind.JsonNode> history(String documentId, AuthContext auth);
    /**
     * Фиксирует новую версию атомарно с проверкой expected version/change token из mutation.
     * При конфликте реализация не должна частично менять документ или состав вложений.
     */
    void commit(DocumentMutation mutation, AuthContext auth);
}
