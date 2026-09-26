package ru.corelia.provider;

import ru.corelia.auth.AuthContext;

/** Проверяет непрозрачное для домена право вызывающего пользователя. */
public interface PermissionProvider {
    /** Проверяет permission и завершает выполнение provider-ошибкой при отсутствии доступа. */
    void require(String permission, AuthContext auth);
}
