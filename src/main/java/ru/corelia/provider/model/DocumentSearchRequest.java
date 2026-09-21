package ru.corelia.provider.model;

/** Ограничение выборки документов для provider adapter. */
public record DocumentSearchRequest(String typeCode, int offset, int limit) {}
