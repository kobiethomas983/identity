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

-- Data Engineer
--Software Engineer
--Sales Manager
--Product Manager
--CEO
--CFO
--CTO
--Sales Executive
--Technical Writer
--UX Designer
--Marketer

CREATE SEQUENCE hibernate_sequence START 1;

INSERT INTO ps_org(id,org_id, company_name, description, website, address)
VALUES(1,'Og1234', 'Clyde', 'Clyde empowers businesses—from startups to enterprises—to.', 'https://www.joinclyde.com/','579 Broadway #2c, New York, NY 10012');

INSERT INTO ps_org(id,org_id, company_name, description, website, address)
VALUES(2,'Og5678', 'Digit', 'Digit uses machine learning and financial best practices to calculate smart amounts to save and invest each day.', 'https://digit.co/','1234 Broadway');

INSERT INTO ps_org(id,org_id, company_name, description, website, address)
VALUES(3,'Og1578', 'Flywire', 'Flywire helps healthcare providers reduce cost and increase cash by making it easier and more affordable for their patients to pay', 'https://www.flywire.com/','Boston Mass');

INSERT INTO ps_org(id,org_id, company_name, description, website, address)
VALUES(4,'Og4322', 'JPMorgan Chase', 'JPMorgan Chase & Co. is an American multinational investment bank and financial services holding company', 'https://www.jpmorganchase.com/','New york, New York');

INSERT INTO ps_org(id,org_id, company_name, description, website, address)
VALUES(5,'Og6619', 'Robinhood', 'Known for pioneering commission-free trades of stocks and exchange-traded funds', 'https://robinhood.com/us/en/','Menlo Park, CA');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(1, 'Id2f12', 'Data Engineer', 'Eldon', 'Pal', 'eldon@gmail.com', 'Og1234');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(2, 'IdLmo1', 'Software Engineer', 'Kayleen', 'Muro', 'kayleen@gmail.com', 'Og1234');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(3, 'Id1234', 'Sales Manager', 'Lisha', 'Reetz', 'lisha@gmail.com', 'Og1234');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(4, 'Idr212', 'Product Manager', 'Kristen', 'Heffington', 'kristen@gmail.com', 'Og5678');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(5, 'Idmm12', 'CEO', 'Frida', 'Ikard', 'frida@gmail.com', 'Og5678');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(6, 'IdMMl2', 'CTO', 'Cordell', 'Paynter', 'cordell@gmail.com', 'Og5678');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(7, 'Id9012', 'Product Manager', 'Bunny', 'Sklar', 'bunny@gmail.com', 'Og1578');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(8, 'IdUU02', 'Software Engineer', 'Verlie', 'Grego', 'verlie@gmail.com', 'Og1578');

INSERT INTO ps_identity(id, identity_id, role, first_name, last_name, email, org_id)
VALUES(9, 'IdMM02', 'Technical Writer', 'Donovan', 'Jansky', 'donovan@gmail.com', 'Og1578');

