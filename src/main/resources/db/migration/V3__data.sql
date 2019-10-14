-- User user/pass
INSERT INTO account (username, email_address, password, enabled)
  values ('user',
    'user@gmail.com',
    '{noop}$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
    1);

INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER');