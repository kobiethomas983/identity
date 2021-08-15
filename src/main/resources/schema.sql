CREATE DATABASE app;

\c app;

CREATE TABLE IF NOT EXISTS ps_identity (
    id bigint,
    first_name TEXT,
    last_name TEXT,
    phone TEXT,
    email TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ps_org (
    id bigint,
    company_name TEXT,
    description TEXT,
    website TEXT,
    address TEXT
)

CREATE SEQUENCE hibernate_sequence START 1;