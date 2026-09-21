package ru.corelia.provider.model;

/** Канонический экземпляр процесса. */
public record ProcessInstance(String id, String documentId, String state) {}
