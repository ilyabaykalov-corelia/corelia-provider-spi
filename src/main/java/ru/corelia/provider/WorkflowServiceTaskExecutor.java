package ru.corelia.provider;

import ru.corelia.provider.model.WorkflowServiceTask;

/** Выполняет разрешённую команду асинхронной BPMN service task. */
public interface WorkflowServiceTaskExecutor {
    /**
     * Выполняет уже разрешённую service task. Исполнитель не должен подменять
     * документную авторизацию или завершать task вне workflow provider.
     */
    void execute(WorkflowServiceTask task);
}
