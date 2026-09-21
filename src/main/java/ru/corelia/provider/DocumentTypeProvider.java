package ru.corelia.provider;

import java.util.List;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.AvailableDocumentType;

/** Доступные текущему пользователю виды документов у выбранного провайдера. */
public interface DocumentTypeProvider {
    List<AvailableDocumentType> available(AuthContext auth);
}
