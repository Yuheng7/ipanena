CREATE TABLE credit_card (
    id SERIAL PRIMARY KEY NOT NULL,
    bank CHARACTER VARYING(255) NOT NULL,
    card_name CHARACTER VARYING(255) NOT NULL
);

-- //@UNDO
-- SQL to undo the change goes here.

-- DROP TABLE card;