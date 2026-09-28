package ru.corelia.provider.model;

/** Проверяемые metadata неизменяемого бинарного содержимого. */
public record BinaryMetadata(long size, String contentType, String checksum) {}
