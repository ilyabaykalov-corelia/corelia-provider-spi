package ru.corelia.provider;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import ru.corelia.config.CoreliaRuntimeConfig;

/** Разрешает provider отдельно для каждой обязательной capability. */
@Component
public class ProviderRegistry {
    private final Map<ProviderCapability, ProviderDescriptor> providers;

    public ProviderRegistry(CoreliaRuntimeConfig config, List<ProviderDescriptor> descriptors) {
        var resolved = new EnumMap<ProviderCapability, ProviderDescriptor>(ProviderCapability.class);
        for (ProviderCapability capability : ProviderCapability.values()) {
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

    public ProviderDescriptor provider(ProviderCapability capability) {
        return providers.get(capability);
    }
}
