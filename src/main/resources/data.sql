INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO CLIENT(id, name) VALUES (1, 'Alex');
INSERT INTO CLIENT(id, name) VALUES (2, 'Jaime');
INSERT INTO CLIENT(id, name) VALUES (3, 'Pedro');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');


INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO PRESTAMO(id, game_id, client_id, fechaInicio, fechaFin) VALUES (1, 1, 1, '2021-02-05', '2022-04-01');
INSERT INTO PRESTAMO(id, game_id, client_id, fechaInicio, fechaFin) VALUES (2, 2, 2, '2021-03-10', '2022-09-21');
INSERT INTO PRESTAMO(id, game_id, client_id, fechaInicio, fechaFin) VALUES (3, 3, 3, '2021-08-12', '2022-10-10');
INSERT INTO PRESTAMO(id, game_id, client_id, fechaInicio, fechaFin) VALUES (4, 4, 2, '2021-10-28', '2022-11-21');
INSERT INTO PRESTAMO(id, game_id, client_id, fechaInicio, fechaFin) VALUES (5, 5, 1, '2021-12-25', '2022-12-31');