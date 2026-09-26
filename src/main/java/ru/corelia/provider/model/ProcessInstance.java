package ru.corelia.provider.model;

/** Канонический экземпляр процесса.
 * @param id идентификатор процесса provider
 * @param documentId связанный документ
 * @param state текущее состояние процесса
 */
public record ProcessInstance(String id, String documentId, String state) {}
