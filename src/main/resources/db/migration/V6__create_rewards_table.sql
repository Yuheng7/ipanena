-- CREATE TABLE reward (
--     id SERIAL,
--     card_name CHARACTER VARYING(255) NOT NULL,
--     description CHARACTER VARYING(255) NOT NULL,
--     PRIMARY KEY (id),
--     FOREIGN KEY (card_name) REFERENCES credit_card(card_name) ON DELETE CASCADE
-- );

CREATE TABLE reward (
    id SERIAL,
    card_name CHARACTER VARYING(255) NOT NULL,
    amount CHARACTER VARYING(255) NOT NULL,
    category CHARACTER VARYING(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (card_name) REFERENCES credit_card(card_name)
);

CREATE TABLE sign_on_bonus (
    id SERIAL,
    card_name CHARACTER VARYING (255) NOT NULL,
    spending CHARACTER VARYING (255) NOT NULL,
    earned CHARACTER VARYING (255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (card_name) REFERENCES credit_card(card_name)
);

-- //@UNDO
-- SQL to undo the change goes here.

-- DROP TABLE card;