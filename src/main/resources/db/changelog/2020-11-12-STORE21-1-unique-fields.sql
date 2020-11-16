-- changeset out-gerasimov-kv:1604405505632-14
ALTER TABLE user_cart
    ADD CONSTRAINT unique_username UNIQUE (username);
-- rollback ALTER TABLE user_cart DROP CONSTRAINT unique_username;