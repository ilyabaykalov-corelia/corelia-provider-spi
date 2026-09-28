package ru.corelia.provider.model;

/** Ограничение выборки документов для provider adapter.
 * @param typeCode тип документа или {@code null} для всех доступных типов
 * @param offset смещение первой записи
 * @param limit максимальное число записей
 */
public record DocumentSearchRequest(String typeCode, int offset, int limit) {}
