-- liquibase formatted sql

-- changeset out-nabokov-rr:1605095528331-1
CREATE TABLE notification (id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, event VARCHAR(255), type INTEGER NOT NULL, user_id BIGINT, CONSTRAINT notification_pkey PRIMARY KEY (id));
-- rollback DROP TABLE notification;

-- changeset out-nabokov-rr:1605095528331-2
ALTER TABLE notification ADD CONSTRAINT subscription UNIQUE (user_id, type, event);
-- rollback ALTER TABLE notification DROP INDEX subscription;