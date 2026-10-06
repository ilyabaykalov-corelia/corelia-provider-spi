package ru.corelia.provider.model;

import java.util.List;

/** Provider-neutral снимок активного runtime процесса. */
public record WorkflowRuntime(List<WorkflowActivityRuntime> activities, List<WorkflowActiveInstance> instances) {
    public WorkflowRuntime { activities = List.copyOf(activities); instances = List.copyOf(instances); }
    public static WorkflowRuntime empty() { return new WorkflowRuntime(List.of(), List.of()); }
}
