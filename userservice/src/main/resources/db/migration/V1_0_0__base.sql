CREATE SCHEMA IF NOT EXISTS shopapp AUTHORIZATION shopapp;

CREATE TABLE shopapp.user (
    id         SERIAL PRIMARY KEY,
    username   TEXT      NOT NULL,
    password   TEXT      NOT NULL,
    first_name TEXT,
    last_name  TEXT,
    created_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP
);
