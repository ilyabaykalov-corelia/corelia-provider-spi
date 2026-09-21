package ru.corelia.provider;

import ru.corelia.auth.AuthContext;

/** Проверяет непрозрачное для домена право вызывающего пользователя. */
public interface PermissionProvider {
    void require(String permission, AuthContext auth);
}
