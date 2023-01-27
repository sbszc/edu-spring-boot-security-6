INSERT INTO user_permission
    (permission_name)
VALUES ('read'),
       ('write');

INSERT INTO user_role
    (role_name)
VALUES ('ADMIN'),
       ('READ_ONLY');

INSERT INTO user_role_permissions
    (user_role_role_name, permissions_permission_name)
VALUES ('ADMIN', 'read'),
       ('ADMIN', 'write'),
       ('READ_ONLY', 'read');

INSERT INTO user_auth
    (username, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled, password)
VALUES ('user', true, true, true, true, 'password'),
       ('admin', true, true, true, true, 'password');

INSERT INTO user_auth_roles
    (user_auth_username, roles_role_name)
VALUES ('admin', 'ADMIN'),
       ('user', 'READ_ONLY');