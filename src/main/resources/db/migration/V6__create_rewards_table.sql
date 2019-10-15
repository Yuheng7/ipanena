CREATE TABLE reward (
    id SERIAL,
    card_name CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (card_name) REFERENCES credit_card(card_name) ON DELETE CASCADE
);

-- //@UNDO
-- SQL to undo the change goes here.

-- DROP TABLE card;