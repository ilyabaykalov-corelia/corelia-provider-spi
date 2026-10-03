package ru.corelia.provider;

import java.util.Set;

/** Идентифицирует зарегистрированный provider и заявленные возможности. */
public interface ProviderDescriptor {
    /** Стабильный идентификатор provider, используемый в runtime configuration. */
    String id();
    /** Capability, которые эта реализация может обслуживать в одном runtime. */
    Set<ProviderCapability> capabilities();
}
