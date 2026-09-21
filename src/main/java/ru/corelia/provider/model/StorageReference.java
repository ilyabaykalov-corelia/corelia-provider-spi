package ru.corelia.provider.model;

/** Непрозрачная ссылка на бинарное содержимое, принадлежащая провайдеру. */
public record StorageReference(String value) {
    public StorageReference {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Storage reference is required");
    }
}
