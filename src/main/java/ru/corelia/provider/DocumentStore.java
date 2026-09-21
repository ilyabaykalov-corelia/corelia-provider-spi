package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.DocumentSearchRequest;
import ru.corelia.provider.model.DocumentSearchResult;
import ru.corelia.provider.model.DocumentSnapshot;

/** Возможность хранения и чтения актуальных документов. */
public interface DocumentStore {
    DocumentSearchResult search(DocumentSearchRequest request, AuthContext auth);
    DocumentSnapshot get(String typeCode, String documentId, AuthContext auth);
}
