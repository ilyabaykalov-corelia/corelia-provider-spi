package ru.corelia.provider.model;

/** Результат сохранения двоичного содержимого.
 * @param reference ссылка provider на контент
 * @param checksum контрольная сумма
 * @param size размер в байтах
 * @param contentType MIME-тип
 */
public record StoredFile(StorageReference reference, String checksum, long size, String contentType) {}
