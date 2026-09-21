package ru.corelia.provider.model;

import tools.jackson.databind.JsonNode;

/** Зафиксированный результат повторяемой команды. */
public record IdempotencyReceipt(String requestHash, JsonNode response) {}
