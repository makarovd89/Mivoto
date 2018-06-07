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
  ('TerraMare', 'Tsvetnoi Blvd., 20/1', '+74956081519'),
  ('Salotto', 'Staropimenovskiy Ln., 11/6', '+79100000920'),
  ('La Bottega Siciliana', 'Okhotny Ryad, 2', '+74956600383'),
  ('Bosco Cafe', 'Krasnaya Sq., 3', '+74956203182'),
  ('Dolkabar', 'Krasina St., 7', '+74992547908'),
  ('Osteria Alberobello', 'Leninskiy Ave., 75A', '+74991343524'),
  ('Porosello', 'Lubyanskiy Drive, 25/2', '+74956235969'),
  ('Pasta and Basta', 'Sretenskiy bulvar, 4 | Metro Chistye Prudi', '+74956245252'),
  ('Osteria Mario', 'Baltiyskaya St., 9', '+74957907090'),
  ('Coffee Room', 'Arbat St., 13', '+74956973553');