package ru.corelia.provider;

/** Определяет engine существующего workflow-идентификатора в период миграции. */
public interface WorkflowEngineResolver {
    boolean ownsProcess(String processInstanceId);
    boolean ownsTask(String taskId);
}
