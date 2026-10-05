# corelia-provider-spi

Модуль задаёт provider-neutral Java-контракты между доменными сервисами Corelia
и адаптерами хранилища, workflow, файлов и разрешений. Он не является
самостоятельным сервисом и не содержит provider SDK.

## Содержимое

- capability interfaces: документы, версии, типы, вложения, binary storage,
  workflow, tasks и permissions;
- immutable canonical models в `ru.corelia.provider.model`;
- `ProviderDescriptor`/`ProviderRegistry`, разрешающие provider по capability;
- временные migration extension points для чтения и замены legacy binary
  references.

В текущем Compose runtime используются native-data, Flowable, S3 и
native-permissions. Конкретная реализация выбирается свойствами
`CORELIA_PROVIDER_*`; SPI не предполагает одного общего provider для всех
capability.

## Использование и проверка

Подключайте модуль из Maven reactor, реализуйте только нужные interfaces и
зарегистрируйте `ProviderDescriptor`. Не пропускайте provider-specific DTO,
SDK types или storage paths через SPI. Проверка модуля:

```bash
mvn -pl corelia-provider-spi -am test
```

Подробная семантика интерфейсов, моделей и существующих implementations:
[../docs/provider-spi.md](../docs/provider-spi.md). Контрактные тесты:
[corelia-provider-tck](../corelia-provider-tck/README.md).
