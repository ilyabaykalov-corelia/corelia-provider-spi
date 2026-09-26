package ru.corelia.provider.model;

/** Представление вида документа, разрешённого текущему пользователю.
 * @param code стабильный код типа
 * @param name отображаемое название
 */
public record AvailableDocumentType(String code, String name) {}
