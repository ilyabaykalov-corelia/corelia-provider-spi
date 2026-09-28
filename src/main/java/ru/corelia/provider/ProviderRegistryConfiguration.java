package ru.corelia.provider;

import java.util.List;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import ru.corelia.config.CoreliaRuntimeConfig;

/** Регистрирует capability-level provider bindings для каждого приложения. */
@AutoConfiguration
public class ProviderRegistryConfiguration {
    @Bean ProviderRegistry providerRegistry(
            @org.springframework.beans.factory.annotation.Qualifier("coreliaRuntimeConfig") CoreliaRuntimeConfig config,
            List<ProviderDescriptor> descriptors) {
        return new ProviderRegistry(config, descriptors);
    }

    @Bean ProviderStartupValidator providerStartupValidator(ProviderRegistry registry) {
        return new ProviderStartupValidator(registry);
    }
}
