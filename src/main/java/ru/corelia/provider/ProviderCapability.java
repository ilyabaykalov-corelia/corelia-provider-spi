package ru.corelia.provider;

/** Обязательные возможности текущего Corelia runtime. */
public enum ProviderCapability {
    DOCUMENTS("documents"),
    DOCUMENT_VERSIONS("document-versions"),
    DOCUMENT_TYPES("document-types"),
    ATTACHMENTS("attachments"),
    BINARY_STORAGE("binary-storage"),
    WORKFLOW("workflow"),
    TASKS("tasks"),
    PERMISSIONS("permissions");

    private final String configurationName;

    ProviderCapability(String configurationName) { this.configurationName = configurationName; }

    /** Имя capability в `corelia.provider.<capability>`. */
    public String configurationName() { return configurationName; }
}
