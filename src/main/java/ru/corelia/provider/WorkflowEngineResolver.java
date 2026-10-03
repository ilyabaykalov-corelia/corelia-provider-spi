package ru.corelia.provider;

/** Определяет engine существующего workflow-идентификатора в период миграции. */
public interface WorkflowEngineResolver {
    /** Определяет, принадлежит ли process instance выбранному engine. */
    boolean ownsProcess(String processInstanceId);
    /** Определяет, принадлежит ли task выбранному engine. */
    boolean ownsTask(String taskId);
}
