-- One To One / One To One:
INSERT INTO billings (fullname, address, phonenumber, dni) VALUES ('Nombre1', 'Comedias', '952111111', '10478552G');
INSERT INTO billings (fullname, address, phonenumber, dni) VALUES ('Nombre2', 'Granada', '951223344', '21548796H');
INSERT INTO billings (fullname, address, phonenumber, dni) VALUES ('Nombre3', 'Larios', '900556677', '36985201I');
INSERT INTO billings (fullname, address, phonenumber, dni) VALUES ('Nombre4', 'Nueva', '902142536', '78945612J');

-- One To Many / One To One:
INSERT INTO users (username, userlastname, dni, active, birthday, id_billinginfo) VALUES ('Marina', 'Madrid', '10478552G', true, '1993-09-10', 1);
INSERT INTO users (username, userlastname, dni, active, birthday, id_billinginfo) VALUES ('Alan', 'Sastre', '21548796H', true, '1990-12-22', 2);
INSERT INTO users (username, userlastname, dni, active, birthday, id_billinginfo) VALUES ('Esteban', 'Quito', '36985201I', false, '1985-03-06', 3);
INSERT INTO users (username, userlastname, dni, active, birthday, id_billinginfo) VALUES ('Adrian', 'Lozano', '78945612J', true, '1984-04-20', 4);

-- Many To One / Many To Many:
INSERT INTO tasks (title, description, finished, deliverydate, id_user) VALUES ('Testing', 'Tests Unitarios', false, '2021-09-17', 3);
INSERT INTO tasks (title, description, finished, deliverydate, id_user) VALUES ('Formacion', 'Curso Full Stack', true, '2021-11-22', 2);
INSERT INTO tasks (title, description, finished, deliverydate, id_user) VALUES ('Base de datos', 'Crear Base Datos', true, '2021-10-12', 1);
INSERT INTO tasks (title, description, finished, deliverydate, id_user) VALUES ('Web', 'Desarrollar App', true, '2021-09-07', 1);

-- Many To Many / Many To Many:
INSERT INTO tags (tagname, color) VALUES ('Tag1', 'BLUE');
INSERT INTO tags (tagname, color) VALUES ('Tag2', 'GREEN');
INSERT INTO tags (tagname, color) VALUES ('Tag3', 'RED');
INSERT INTO tags (tagname, color) VALUES ('Tag4', 'YELLOW');

INSERT INTO tags_tasks (id_tag, id_task) VALUES (1, 2);
INSERT INTO tags_tasks (id_tag, id_task) VALUES (2, 1);
INSERT INTO tags_tasks (id_tag, id_task) VALUES (4, 4);
INSERT INTO tags_tasks (id_tag, id_task) VALUES (3, 3);