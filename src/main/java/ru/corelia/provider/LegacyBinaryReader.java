package ru.corelia.provider;

import java.io.InputStream;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.StorageReference;

/** Временный read-only bridge для historical binary references во время миграции. */
public interface LegacyBinaryReader {
    /** Возвращает {@code true}, если reader способен обработать scheme ссылки. */
    boolean supports(StorageReference reference);
    /**
     * Открывает поток legacy-содержимого. Вызывающий закрывает поток; метод
     * предназначен только для bridge-сценария и не создаёт новую ссылку.
     */
    InputStream read(StorageReference reference, AuthContext auth);
}
