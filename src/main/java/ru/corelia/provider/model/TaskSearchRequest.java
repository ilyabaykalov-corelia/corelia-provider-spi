package ru.corelia.provider.model;

import java.util.Set;

/** Семантические критерии выборки задач Corelia. */
public record TaskSearchRequest(Set<String> statuses) {
    public TaskSearchRequest { statuses = Set.copyOf(statuses); }
}
