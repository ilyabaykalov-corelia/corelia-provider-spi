package ru.corelia.provider;

import ru.corelia.auth.AuthContext;
import ru.corelia.provider.model.ProcessInstance;
import ru.corelia.provider.model.WorkflowDefinition;
import ru.corelia.provider.model.WorkflowContext;
import ru.corelia.provider.model.WorkflowValidation;
import java.util.List;

/** Возможность запуска и чтения процессов. */
public interface WorkflowProvider {
    /** Запускает процесс для контекста документа; повтор семантически определяется provider. */
    ProcessInstance start(WorkflowContext context, AuthContext auth);
    /** Возвращает текущее состояние экземпляра процесса, доступного вызывающему пользователю. */
    ProcessInstance process(String processInstanceId, AuthContext auth);
    /** Возвращает опубликованные процессы, которыми владеет выбранный workflow provider. */
    default List<WorkflowDefinition> definitions(AuthContext auth) { return List.of(); }
    /** Проверяет BPMN-процесс перед публикацией без его развёртывания. */
    default WorkflowValidation validateDefinition(String key, String bpmnXml, AuthContext auth) {
        throw new UnsupportedOperationException("Проверка BPMN не поддерживается выбранным workflow provider");
    }
    /** Публикует проверенное определение как новую неизменяемую версию provider. */
    default WorkflowDefinition publishDefinition(String key, String name, String bpmnXml, AuthContext auth) {
        throw new UnsupportedOperationException("Публикация BPMN не поддерживается выбранным workflow provider");
    }
    /** Прекращает запуск новых экземпляров опубликованного процесса, сохраняя историю. */
    default void retireDefinition(String key, AuthContext auth) {
        throw new UnsupportedOperationException("Вывод BPMN из эксплуатации не поддерживается выбранным workflow provider");
    }
}
