package ru.corelia.provider.model;

/** Зарезервированное provider-ом место неизменяемого содержимого до его записи. */
public record BinaryLocation(
        StorageReference reference,
        String storageProvider,
        String bucket,
        String objectKey) {}
