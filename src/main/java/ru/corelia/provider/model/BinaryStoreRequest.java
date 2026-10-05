package ru.corelia.provider.model;

/** Семантика сохраняемого вложения, не раскрывающая устройство хранилища provider-а. */
public record BinaryStoreRequest(
        String documentId,
        String attachmentId,
        String fileName,
        String contentType,
        long size,
        String checksum,
        StorageReference reference) {
    public BinaryStoreRequest(
            String documentId,
            String attachmentId,
            String fileName,
            String contentType,
            long size,
            String checksum) {
        this(documentId, attachmentId, fileName, contentType, size, checksum, null);
    }

    /** Возвращает копию запроса с ранее зарезервированной непрозрачной ссылкой. */
    public BinaryStoreRequest withReference(StorageReference value) {
        return new BinaryStoreRequest(documentId, attachmentId, fileName, contentType, size, checksum, value);
    }
}
