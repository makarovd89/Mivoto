DELETE FROM restaurants;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('user', 'user@yandex.ru', 'userpass'),
  ('admin', 'admin@gmail.com', 'password');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO restaurants (name, address, phone) VALUES
  ('TerraMare', 'Tsvetnoi Blvd., 20/1, Moscow 127051, Russia', '+74956081519'),
  ('Salotto', 'Staropimenovskiy Ln., 11/6, Moscow 125009, Russia', '+79100000920'),
  ('La Bottega Siciliana', 'Okhotny Ryad, 2, Moscow 125009, Russia', '+74956600383');