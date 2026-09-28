package ru.corelia.provider;

import java.io.InputStream;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.BinaryStoreRequest;
import ru.corelia.provider.model.StorageReference;
import ru.corelia.provider.model.StoredFile;

/** Возможность хранения и выдачи бинарного содержимого. */
public interface BinaryStorage {
    /** Сохраняет поток и возвращает неизменяемую ссылку на сохранённое содержимое. */
    StoredFile store(BinaryStoreRequest request, InputStream content, AuthContext auth);
    /** Открывает поток содержимого; вызывающий обязан закрыть полученный {@link InputStream}. */
    InputStream read(StorageReference reference, AuthContext auth);
}
