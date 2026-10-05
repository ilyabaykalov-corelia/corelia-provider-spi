package ru.corelia.provider;


/** Проверяет resolved bindings до обработки пользовательских запросов. */
public final class ProviderStartupValidator {
    public ProviderStartupValidator(ProviderRegistry registry) {
        for (ProviderCapability capability : registry.resolvedCapabilities()) {
            if (registry.provider(capability) == null) {
                throw new IllegalStateException(
                        "Не разрешён provider для capability '" + capability.configurationName() + "'");
            }
        }
    }
}
