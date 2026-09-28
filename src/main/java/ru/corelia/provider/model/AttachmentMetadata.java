package ru.corelia.provider.model;

import java.time.Instant;

/** Метаданные версии вложения без формата файлового хранилища.
 * @param id идентификатор версии
 * @param logicalId идентификатор логического вложения
 * @param documentId идентификатор документа
 * @param fileName исходное имя файла
 * @param contentType MIME-тип
 * @param size размер в байтах
 * @param version номер версии
 * @param current признак текущей версии
 * @param uploadedAt время загрузки
 * @param storageReference непрозрачная ссылка на содержимое
 */
public record AttachmentMetadata(String id, String logicalId, String documentId, String fileName,
                                 String contentType, long size, long version, boolean current,
                                 Instant uploadedAt, StorageReference storageReference) {}
