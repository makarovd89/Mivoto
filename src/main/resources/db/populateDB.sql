DELETE FROM votes;
DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM menu;
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

INSERT INTO menu (date, restaurant_id) VALUES
  ('2017-12-30', 100002),
  ('2017-12-30', 100003),
  ('2017-12-30', 100004),
  ('2017-12-30', 100005),
  ('2017-12-30', 100006),
  ('2017-12-30', 100007),
  ('2017-12-30', 100008),
  ('2017-12-30', 100009),
  ('2017-12-31', 100010);

INSERT INTO dishes (description, price, menu_id) VALUES
  ('British crab spaghetti', 14.75, 100012),
  ('Oxtail Lasagne', 13.95, 100012),
  ('Tiramisu', 5.95, 100012),
  ('Squash Cannelloni', 12.95, 100013),
  ('The carbonara', 11.95, 100013),
  ('Sausage Ravioli', 12.95, 100014),
  ('Sicilian chicken', 14.95, 100014),
  ('Sweet potato fries', 4.00, 100015),
  ('The Porkie', 12.95, 100015),
  ('The Funghi', 12.95, 100016),
  ('The Tuscan', 12.95, 100017),
  ('The Meetball', 12.95, 100018),
  ('The Julietta', 11.95, 100018),
  ('Pumpkin arancini', 5.95, 100019),
  ('Mushroom fritti', 5.95, 100019),
  ('Italian meatballs', 6.25, 100019),
  ('Gennaro''s mixed grill', 19.95, 100020),
  ('Tender roasted aubergin', 9.95, 100020);

INSERT INTO votes (date, user_id, restaurant_id) VALUES
  ('2017-12-29',100000,100003),
  ('2017-12-30',100000,100003),
  ('2017-12-31',100000,100003);