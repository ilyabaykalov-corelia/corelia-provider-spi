package ru.corelia.provider.model;

/** Семантика сохраняемого вложения, не раскрывающая устройство хранилища provider-а. */
public record BinaryStoreRequest(
        String documentId,
        String attachmentId,
        String fileName,
        String contentType,
        long size,
        String checksum) {}
