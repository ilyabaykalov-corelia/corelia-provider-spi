package ru.corelia.provider;

import java.io.InputStream;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.BinaryStoreRequest;
import ru.corelia.provider.model.StorageReference;
import ru.corelia.provider.model.StoredFile;

/** Возможность хранения и выдачи бинарного содержимого. */
public interface BinaryStorage {
    StoredFile store(BinaryStoreRequest request, InputStream content, AuthContext auth);
    InputStream read(StorageReference reference, AuthContext auth);
}
