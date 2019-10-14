CREATE TABLE account (
    id SERIAL PRIMARY KEY NOT NULL,
    email_address CHARACTER VARYING(255) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled INTEGER NOT NULL DEFAULT 1
);

CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (username) REFERENCES account(username)
);

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);