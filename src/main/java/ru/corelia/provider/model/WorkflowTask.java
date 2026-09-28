package ru.corelia.provider.model;

import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;

/** Каноническая задача процесса.
 * @param id идентификатор задачи
 * @param documentId связанный документ
 * @param documentType тип документа
 * @param status состояние задачи
 * @param assignee технический исполнитель
 * @param assigneeName имя исполнителя
 * @param assigneeRole роль исполнителя
 * @param title заголовок
 * @param description описание
 * @param attributes значения задачи
 * @param actions разрешённые действия
 */
public record WorkflowTask(String id, String documentId, String documentType, String status,
                           String assignee, String assigneeName, String assigneeRole, String title,
                           String description, Map<String, JsonNode> attributes, List<WorkflowAction> actions) {
    public WorkflowTask { attributes = Map.copyOf(attributes); actions = List.copyOf(actions); }
}
