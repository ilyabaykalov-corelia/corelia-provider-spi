package ru.corelia.provider.model;

import java.util.List;
import tools.jackson.databind.JsonNode;

/** Provider-neutral AST фильтра поиска документов без SQL и JSONPath. */
public sealed interface DocumentSearchFilter permits DocumentSearchFilter.Comparison, DocumentSearchFilter.Group, DocumentSearchFilter.Negation {
    enum Operator { EQ, NE, GT, GTE, LT, LTE, IN, NOT_IN, EXISTS, CONTAINS, STARTS_WITH }
    enum LogicalOperator { AND, OR }
    record Comparison(String field, Operator operator, JsonNode value) implements DocumentSearchFilter {}
    record Group(LogicalOperator operator, List<DocumentSearchFilter> items) implements DocumentSearchFilter {
        public Group { items = List.copyOf(items); }
    }
    record Negation(DocumentSearchFilter item) implements DocumentSearchFilter {}
}
