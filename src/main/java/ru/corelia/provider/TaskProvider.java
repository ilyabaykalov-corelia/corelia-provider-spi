package ru.corelia.provider;

import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.WorkflowTask;
import ru.corelia.provider.model.TaskSearchRequest;

/** Возможность поиска и выполнения задач. */
public interface TaskProvider {
    /** Ищет доступные пользователю задачи по статусам. */
    List<WorkflowTask> search(TaskSearchRequest request, AuthContext auth);
    /** Возвращает задачи, связанные с конкретным документом. */
    List<WorkflowTask> findByDocument(String documentId, AuthContext auth);
    /** Получает одну задачу с проверкой доступа. */
    WorkflowTask task(String taskId, AuthContext auth);
    /** Преобразует технический role в отображаемую метку provider. */
    String roleLabel(String role, AuthContext auth);
    /** Берёт задачу в работу; provider сообщает конфликт состояния, а не скрывает его. */
    void start(String taskId, AuthContext auth);
    /** Завершает задачу с параметрами действия после проверки доступного transition. */
    void complete(String taskId, Map<String, JsonNode> parameters, AuthContext auth);
}
