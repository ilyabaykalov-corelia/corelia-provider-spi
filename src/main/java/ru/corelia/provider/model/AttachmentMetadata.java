package ru.corelia.provider.model;

import java.time.Instant;

/** Метаданные версии вложения без формата файлового хранилища. */
public record AttachmentMetadata(String id, String logicalId, String documentId, String fileName,
                                 String contentType, long size, long version, boolean current,
                                 Instant uploadedAt, StorageReference storageReference) {}
