-- liquibase formatted sql

-- changeset out-nabokov-rr:1605095528331-3
DROP TABLE notification;
-- rollback CREATE TABLE notification (id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, event VARCHAR(255), type INTEGER, user_id BIGINT NOT NULL, CONSTRAINT notification_pkey PRIMARY KEY (id));

-- changeset out-nabokov-rr:1605095528331-4
DROP SEQUENCE IF EXISTS hibernate_sequence RESTRICT
-- rollback CREATE SEQUENCE  IF NOT EXISTS hibernate_sequence AS bigint START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

