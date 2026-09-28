package ru.corelia.provider.model;

/** Непрозрачная ссылка на бинарное содержимое, принадлежащая провайдеру. */
public record StorageReference(String value) {
    public StorageReference {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Storage reference is required");
    }

    /** Возвращает provider-owned scheme; path не интерпретируется generic Corelia. */
    public String scheme() {
        int separator = value.indexOf(':');
        if (separator <= 0) throw new IllegalArgumentException("Storage reference не содержит scheme");
        return value.substring(0, separator);
    }
}
