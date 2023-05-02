CREATE TABLE image
(
    id          bigserial    NOT NULL,
    employee_id bigint       NULL,
    photo       bytea NULL,
    date        timestamp    NULL,
    CONSTRAINT images_pk PRIMARY KEY (id)
);