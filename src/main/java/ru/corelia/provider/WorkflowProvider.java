package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.ProcessInstance;
import ru.corelia.provider.model.WorkflowContext;

/** Возможность запуска и чтения процессов. */
public interface WorkflowProvider {
    ProcessInstance start(WorkflowContext context, AuthContext auth);
    ProcessInstance get(String processInstanceId, AuthContext auth);
}
