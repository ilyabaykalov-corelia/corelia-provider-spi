package ru.corelia.provider;

import java.util.EnumSet;

/** Проверяет descriptor выбранного provider до обработки пользовательских запросов. */
public final class ProviderStartupValidator {
    private ProviderStartupValidator() {}
    public static void validate(String selected, ProviderDescriptor provider) {
        if (!selected.equals(provider.id())) throw new IllegalStateException("Выбран provider '" + selected + "', зарегистрирован '" + provider.id() + "'");
        var required = EnumSet.allOf(ProviderCapability.class);
        if (!provider.capabilities().containsAll(required)) throw new IllegalStateException("Provider '" + provider.id() + "' не предоставляет обязательные capabilities: " + required);
    }
}
