package ru.corelia.provider.model;

import java.util.List;

/** Страница канонических снимков документов.
 * @param items найденные snapshots
 * @param total общее число результатов до pagination
 */
public record DocumentSearchResult(List<DocumentSnapshot> items, long total) {
    public DocumentSearchResult { items = List.copyOf(items); }
}
