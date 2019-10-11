CREATE TABLE account (
    id SERIAL PRIMARY KEY NOT NULL,
    username CHARACTER VARYING(255) NOT NULL UNIQUE,
    email_address CHARACTER VARYING(255) NOT NULL UNIQUE,
    password CHARACTER VARYING(255) NOT NULL
);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE account;
