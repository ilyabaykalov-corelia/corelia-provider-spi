package ru.corelia.provider;

import java.io.InputStream;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.StorageReference;

/** Временный read-only bridge для historical binary references во время миграции. */
public interface LegacyBinaryReader {
    boolean supports(StorageReference reference);
    InputStream read(StorageReference reference, AuthContext auth);
}
