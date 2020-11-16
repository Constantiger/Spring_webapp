--liquibase formatted sql

-- changeset out-gerasimov-kv:1604405505632-10
DROP TABLE user_role;
-- rollback CREATE TABLE user_role (user_id BIGINT NOT NULL, roles VARCHAR(255));

-- changeset out-gerasimov-kv:1604405505632-11
DROP TABLE usr;
-- rollback CREATE TABLE usr (id BIGINT NOT NULL, active BOOLEAN NOT NULL, email VARCHAR(255), password VARCHAR(255), username VARCHAR(255), CONSTRAINT usr_pkey PRIMARY KEY (id));

-- changeset out-gerasimov-kv:1604405505632-12
ALTER TABLE product ALTER COLUMN text TYPE text;
-- rollback ALTER TABLE product ALTER COLUMN text TYPE VARCHAR(255);