package ru.corelia.provider.model;

import tools.jackson.databind.JsonNode;

/** Зафиксированный результат повторяемой команды.
 * @param requestHash hash исходной команды
 * @param response сохранённый ответ
 */
public record IdempotencyReceipt(String requestHash, JsonNode response) {}
