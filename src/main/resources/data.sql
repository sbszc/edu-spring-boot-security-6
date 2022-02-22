INSERT INTO user_permission
    (permission_name)
VALUES ('USER_READ'),
       ('USER_WRITE');

INSERT INTO user_role
    (role_name)
VALUES ('ADMIN'),
       ('READONLY_ADMIN');

INSERT INTO user_role_permissions
    (user_role_role_name, permissions_permission_name)
VALUES ('ADMIN', 'USER_READ'),
       ('ADMIN', 'USER_WRITE'),
       ('READONLY_ADMIN', 'USER_READ');

INSERT INTO user_auth
(username, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, password)
VALUES ('admin', true, true, true, true, 'pass'),
       ('readonly', true, true, true, true, 'pass');

INSERT INTO user_auth_roles
    (user_auth_username, roles_role_name)
VALUES ('admin', 'ADMIN'),
       ('readonly', 'READONLY_ADMIN');