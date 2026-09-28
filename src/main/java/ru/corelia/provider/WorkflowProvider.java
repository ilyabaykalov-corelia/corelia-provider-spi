package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.ProcessInstance;
import ru.corelia.provider.model.WorkflowContext;

/** Возможность запуска и чтения процессов. */
public interface WorkflowProvider {
    /** Запускает процесс для контекста документа; повтор семантически определяется provider. */
    ProcessInstance start(WorkflowContext context, AuthContext auth);
    /** Возвращает текущее состояние экземпляра процесса, доступного вызывающему пользователю. */
    ProcessInstance process(String processInstanceId, AuthContext auth);
}
