package ru.corelia.provider;

import ru.corelia.provider.model.WorkflowServiceTask;

/** Выполняет разрешённую команду асинхронной BPMN service task. */
public interface WorkflowServiceTaskExecutor {
    void execute(WorkflowServiceTask task);
}
