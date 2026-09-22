package ru.corelia.provider;

import java.util.Set;

/** Идентифицирует зарегистрированный provider и заявленные возможности. */
public interface ProviderDescriptor {
    String id();
    Set<ProviderCapability> capabilities();
}
