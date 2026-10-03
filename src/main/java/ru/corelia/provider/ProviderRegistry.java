package ru.corelia.provider;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import ru.corelia.config.CoreliaRuntimeConfig;

/** Разрешает provider отдельно для каждой обязательной capability. */
public class ProviderRegistry {
    private final Map<ProviderCapability, ProviderDescriptor> providers;

    /**
     * Разрешает bindings на старте и отклоняет отсутствующую либо неоднозначную
     * реализацию до обработки пользовательских запросов.
     */
    public ProviderRegistry(CoreliaRuntimeConfig config, List<ProviderDescriptor> descriptors) {
        var resolved = new EnumMap<ProviderCapability, ProviderDescriptor>(ProviderCapability.class);
        for (ProviderCapability capability : requiredCapabilities(config)) {
            String selected = config.provider(capability.configurationName());
            var matches = descriptors.stream()
                    .filter(descriptor -> descriptor.id().equals(selected))
                    .filter(descriptor -> descriptor.capabilities().contains(capability))
                    .toList();
            if (matches.size() != 1) {
                throw new IllegalStateException(
                        "Для capability '" + capability.configurationName() + "' выбран provider '"
                                + selected + "', найдено implementations: " + matches.size());
            }
            resolved.put(capability, matches.getFirst());
        }
        providers = Map.copyOf(resolved);
    }

    private static java.util.Set<ProviderCapability> requiredCapabilities(CoreliaRuntimeConfig config) {
        String configured = config.value("CORELIA_PROVIDER_CAPABILITIES");
        if (configured.isBlank()) return java.util.EnumSet.allOf(ProviderCapability.class);
        var capabilities = java.util.EnumSet.noneOf(ProviderCapability.class);
        for (String name : configured.split(",")) {
            String normalized = name.trim().replace('-', '_').toUpperCase(java.util.Locale.ROOT);
            if (normalized.isEmpty()) continue;
            try {
                capabilities.add(ProviderCapability.valueOf(normalized));
            } catch (IllegalArgumentException exception) {
                throw new IllegalArgumentException("Неизвестная capability provider: " + name, exception);
            }
        }
        if (capabilities.isEmpty()) throw new IllegalArgumentException("CORELIA_PROVIDER_CAPABILITIES не должен быть пустым");
        return capabilities;
    }

    /** Возвращает descriptor выбранной capability или {@code null}, если она не требовалась приложению. */
    public ProviderDescriptor provider(ProviderCapability capability) {
        return providers.get(capability);
    }

    /** Возвращает неизменяемый набор capability, обязательных для текущего приложения. */
    public java.util.Set<ProviderCapability> resolvedCapabilities() {
        return providers.keySet();
    }
}
