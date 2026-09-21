package ru.corelia.provider.model;

import java.util.List;

/** Страница канонических снимков документов. */
public record DocumentSearchResult(List<DocumentSnapshot> items, long total) {
    public DocumentSearchResult { items = List.copyOf(items); }
}
