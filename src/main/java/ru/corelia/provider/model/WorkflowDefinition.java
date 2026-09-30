package ru.corelia.provider.model;

import java.time.Instant;

/** Опубликованное определение процесса в нейтральном представлении Corelia. */
public record WorkflowDefinition(
        String name,
        String key,
        int publishedVersion,
        boolean draft,
        String status,
        Instant lastPublishedAt,
        String publishedBy,
        long activeInstances) {}
