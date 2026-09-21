package ru.corelia.provider;

import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;
import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.WorkflowTask;

/** Возможность поиска и выполнения задач. */
public interface TaskProvider {
    List<WorkflowTask> findByDocument(String documentId, AuthContext auth);
    WorkflowTask get(String taskId, AuthContext auth);
    void start(String taskId, AuthContext auth);
    void complete(String taskId, Map<String, JsonNode> parameters, AuthContext auth);
}
