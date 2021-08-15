CREATE DATABASE app;

\c app;

CREATE TABLE IF NOT EXISTS ps_identity (
    id TEXT,
    first_name TEXT,
    last_name TEXT,
    phone TEXT,
    email TEXT
);