CREATE DATABASE app;

\c app;

CREATE TABLE IF NOT EXISTS ps_org (
    id bigint,
    org_id TEXT UNIQUE NOT NULL,
    company_name TEXT,
    description TEXT,
    website TEXT,
    address TEXT,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS ps_identity (
    id bigint,
    identity_id TEXT UNIQUE NOT NULL,
    role TEXT,
    first_name TEXT,
    last_name TEXT,
    phone TEXT,
    email TEXT,
    org_id TEXT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_org
        FOREIGN KEY(org_id)
            REFERENCES ps_org(org_id)
);

CREATE SEQUENCE hibernate_sequence START 1;