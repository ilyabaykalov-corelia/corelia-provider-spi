package ru.corelia.provider.model;

/** Результат сохранения двоичного содержимого. */
public record StoredFile(StorageReference reference, String checksum, long size, String contentType) {}
