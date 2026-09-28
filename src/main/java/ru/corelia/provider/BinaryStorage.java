package ru.corelia.provider;

import java.io.InputStream;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.BinaryStoreRequest;
import ru.corelia.provider.model.BinaryLocation;
import ru.corelia.provider.model.BinaryMetadata;
import ru.corelia.provider.model.StorageReference;
import ru.corelia.provider.model.StoredFile;

/** Возможность хранения и выдачи бинарного содержимого. */
public interface BinaryStorage {
    /** Резервирует logical location, не создавая физический объект. */
    default BinaryLocation reserve(BinaryStoreRequest request, AuthContext auth) {
        throw new UnsupportedOperationException("Provider не поддерживает резервирование binary content");
    }
    /** Сохраняет поток и возвращает неизменяемую ссылку на сохранённое содержимое. */
    StoredFile store(BinaryStoreRequest request, InputStream content, AuthContext auth);
    /** Открывает поток содержимого; вызывающий обязан закрыть полученный {@link InputStream}. */
    InputStream read(StorageReference reference, AuthContext auth);

    /** Открывает диапазон содержимого; provider может заменить реализацию оптимальным запросом. */
    default InputStream read(StorageReference reference, long offset, long length, AuthContext auth) {
        if (offset < 0 || length < 1) throw new IllegalArgumentException("Некорректный диапазон binary content");
        try {
            InputStream source = read(reference, auth);
            source.skipNBytes(offset);
            return new java.io.FilterInputStream(source) {
                private long remaining = length;
                @Override public int read() throws java.io.IOException {
                    if (remaining == 0) return -1;
                    int value = super.read();
                    if (value != -1) remaining--;
                    return value;
                }
                @Override public int read(byte[] bytes, int offset, int count) throws java.io.IOException {
                    if (remaining == 0) return -1;
                    int actual = super.read(bytes, offset, (int) Math.min(count, remaining));
                    if (actual > 0) remaining -= actual;
                    return actual;
                }
            };
        } catch (java.io.IOException error) {
            throw new IllegalStateException("Не удалось открыть диапазон binary content", error);
        }
    }

    /** Возвращает metadata содержимого без выдачи его полного потока. */
    default BinaryMetadata metadata(StorageReference reference, AuthContext auth) {
        throw new UnsupportedOperationException("Provider не поддерживает metadata binary content");
    }

    /** Удаляет физическое содержимое после завершения lifecycle blob-а. */
    default void delete(StorageReference reference, AuthContext auth) {
        throw new UnsupportedOperationException("Provider не поддерживает удаление binary content");
    }
}
