package ru.corelia.provider;

import org.springframework.stereotype.Component;

/** Проверяет resolved bindings до обработки пользовательских запросов. */
@Component
public final class ProviderStartupValidator {
    public ProviderStartupValidator(ProviderRegistry registry) {
        for (ProviderCapability capability : ProviderCapability.values()) {
            if (registry.provider(capability) == null) {
                throw new IllegalStateException(
                        "Не разрешён provider для capability '" + capability.configurationName() + "'");
            }
        }
    }
}
