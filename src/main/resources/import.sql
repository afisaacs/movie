INSERT INTO ciudad (id, registro, codigo, nombre) VALUES (1, now(), 'BOG', 'Bogot� D.C.');
INSERT INTO ciudad (id, registro, codigo, nombre) VALUES (2, now(), 'MED', 'Medell�n');
INSERT INTO ciudad (id, registro, codigo, nombre) VALUES (3, now(), 'BAQ', 'Baranquilla');
INSERT INTO ciudad (id, registro, codigo, nombre) VALUES (4, now(), 'IBA', 'Ibagu�');
INSERT INTO ciudad (id, registro, codigo, nombre) VALUES (5, now(), 'CAR', 'Cartagena');

INSERT INTO formato (id, registro, nombre) VALUES (1, now(), '2D');
INSERT INTO formato (id, registro, nombre) VALUES (2, now(), '3D');
INSERT INTO formato (id, registro, nombre) VALUES (3, now(), 'Dynamix');

INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (1, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'ADMIN');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (2, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'ADMIN');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (3, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'ADMIN');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (4, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'ADMIN');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (5, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'USUARIO');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (6, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'USUARIO');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (7, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'USUARIO');
INSERT INTO usuario (id, registro, nombre, apellido, correo, password, rol) VALUES (8, now(), 'Aaron Felipe', 'Isaacs Ortiz', 'aaron.isaacs@ingeneo.com', '000000', 'USUARIO');

INSERT INTO genero (id, nombre, registro) VALUES (1, 'Acci�n', now());
INSERT INTO genero (id, nombre, registro) VALUES (2, 'Terror', now());
INSERT INTO genero (id, nombre, registro) VALUES (3, 'Aventura', now());
INSERT INTO genero (id, nombre, registro) VALUES (4, 'Suspenso', now());
INSERT INTO genero (id, nombre, registro) VALUES (5, 'Comedia', now());

INSERT INTO atributo_pelicula (id, nombre, registro, tipo) VALUES (1, 'attuno', now(), 'TEXTO');
INSERT INTO atributo_pelicula (id, nombre, registro, tipo) VALUES (2, 'attdos', now(), 'FECHA');
INSERT INTO atributo_pelicula (id, nombre, registro, tipo) VALUES (3, 'atttres', now(), 'NUMERO');
INSERT INTO atributo_pelicula (id, nombre, registro, tipo) VALUES (4, 'attcuatro', now(), 'LISTA');

INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (1, 'Unicentro', 'Unicentro', now(), 1, 1);
INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (2, 'Centro Mayor', 'Centro Mayor', now(), 1, 1);
INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (3, 'Diver Plaza', 'Diver Plaza', now(), 2, 1);
INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (4, 'Moga Moll', 'Moga Moll', now(), 2, 2);
INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (5, 'MultiCentro', 'MultiCentro', now(), 3, 2);
INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (6, 'Plaza Central', 'Plaza Central', now(), 3, 3);
INSERT INTO sucursal (id, direccion, nombre, registro, administrador_id, ciudad_id) VALUES (7, 'Super', 'Super', now(), 4, 3);

INSERT INTO sala (id, filas, registro, sillas, formato_id, sucursal_id) VALUES (1, 20, now(), 10, 1, 1);
INSERT INTO sala (id, filas, registro, sillas, formato_id, sucursal_id) VALUES (2, 25, now(), 9, 2, 1);
INSERT INTO sala (id, filas, registro, sillas, formato_id, sucursal_id) VALUES (3, 23, now(), 8, 3, 2);
INSERT INTO sala (id, filas, registro, sillas, formato_id, sucursal_id) VALUES (5, 27, now(), 7, 1, 2);

INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (1, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:03:47', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (2, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:17', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (3, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:22', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (4, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:22', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (5, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (6, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (7, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (8, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (9, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (10, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (11, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (12, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:23', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (13, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:24', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (14, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:24', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (15, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:24', 'Sinapsis', 1);
INSERT INTO pelicula (id, duration, fecha_baja, fecha_estreno, nombre_original, nombre_traducido, portada, registro, sinopsis, formato_id) VALUES (16, 600, '2019-09-15', '2019-09-15', 'Nombre original', 'Nombre traducido', null, '2019-09-15 13:05:24', 'Sinapsis', 1);

INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (1, 'test', 1, 1);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (2, 'test dos', 2, 1);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (3, 'test', 1, 2);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (4, 'test dos', 2, 2);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (5, 'test', 1, 3);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (6, 'test dos', 2, 3);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (7, 'test', 1, 4);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (8, 'test dos', 2, 4);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (9, 'test', 1, 5);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (10, 'test dos', 2, 5);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (11, 'test', 1, 6);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (12, 'test dos', 2, 6);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (13, 'test', 1, 7);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (14, 'test dos', 2, 7);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (15, 'test', 1, 8);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (16, 'test dos', 2, 8);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (17, 'test', 1, 9);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (18, 'test dos', 2, 9);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (19, 'test', 1, 10);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (20, 'test dos', 2, 10);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (21, 'test', 1, 11);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (22, 'test dos', 2, 11);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (23, 'test', 1, 12);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (24, 'test dos', 2, 12);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (25, 'test', 1, 13);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (26, 'test dos', 2, 13);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (27, 'test', 1, 14);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (28, 'test dos', 2, 14);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (29, 'test', 1, 15);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (30, 'test dos', 2, 15);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (31, 'test', 1, 16);
INSERT INTO valor_atributo_pelicula (id, valor, atributo_id, pelicula_id) VALUES (32, 'test dos', 2, 16);

INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (1, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (1, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (1, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (2, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (2, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (2, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (3, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (3, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (3, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (4, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (4, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (4, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (5, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (5, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (5, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (6, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (6, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (6, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (7, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (7, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (7, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (8, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (8, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (8, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (9, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (9, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (9, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (10, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (10, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (10, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (11, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (11, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (11, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (12, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (12, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (12, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (13, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (13, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (13, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (14, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (14, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (14, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (15, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (15, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (15, 3);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (16, 1);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (16, 2);
INSERT INTO pelicula_generos (pelicula_id, generos_id) VALUES (16, 3);

INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (1, 1, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (2, 1, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (3, 1, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (4, 1, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (5, 1, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (6, 1, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (7, 2, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (8, 2, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (9, 2, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (10, 2, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (11, 2, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (12, 2, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (13, 3, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (14, 3, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (15, 3, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (16, 3, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (17, 3, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (18, 3, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (19, 4, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (20, 4, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (21, 4, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (22, 4, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (23, 4, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (24, 4, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (25, 5, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (26, 5, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (27, 5, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (28, 5, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (29, 5, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (30, 5, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (31, 6, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (32, 6, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (33, 6, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (34, 6, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (35, 6, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (36, 6, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (37, 7, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (38, 7, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (39, 7, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (40, 7, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (41, 7, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (42, 7, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (43, 8, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (44, 8, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (45, 8, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (46, 8, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (47, 8, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (48, 8, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (49, 9, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (50, 9, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (51, 9, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (52, 9, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (53, 9, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (54, 9, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (55, 10, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (56, 10, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (57, 10, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (58, 10, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (59, 10, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (60, 10, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (61, 11, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (62, 11, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (63, 11, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (64, 11, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (65, 11, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (66, 11, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (67, 12, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (68, 12, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (69, 12, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (70, 12, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (71, 12, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (72, 12, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (73, 13, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (74, 13, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (75, 13, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (76, 13, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (77, 13, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (78, 13, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (79, 14, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (80, 14, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (81, 14, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (82, 14, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (83, 14, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (84, 14, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (85, 15, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (86, 15, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (87, 15, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (88, 15, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (89, 15, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (90, 15, 6);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (91, 16, 1);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (92, 16, 2);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (93, 16, 3);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (94, 16, 4);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (95, 16, 5);
INSERT INTO catalogo (id, pelicula_id, sucursal_id) VALUES (96, 16, 6);

INSERT INTO agenda (id, fecha, registro, pelicula_id, sala_id) VALUES (1, '2019-09-15 18:39:01', '2019-09-15 18:41:07', 1, 1);
INSERT INTO agenda (id, fecha, registro, pelicula_id, sala_id) VALUES (2, '2019-09-15 18:39:01', '2019-09-15 18:41:12', 2, 1);
INSERT INTO agenda (id, fecha, registro, pelicula_id, sala_id) VALUES (3, '2019-09-15 18:39:01', '2019-09-15 18:41:16', 3, 1);