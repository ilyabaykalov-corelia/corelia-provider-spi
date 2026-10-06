package ru.corelia.provider.model;

import java.util.Set;

/** Активный экземпляр процесса и его текущие BPMN activity. */
public record WorkflowActiveInstance(String id, String documentId, String documentType, Set<String> activityIds) {
    public WorkflowActiveInstance { activityIds = Set.copyOf(activityIds); }
}
