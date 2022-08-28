-- MYSQL
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, STR_TO_DATE('01-01-2016', '%d-%m-%Y'));
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, STR_TO_DATE('01-01-2016','%d-%m-%Y'));
INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, STR_TO_DATE('01-01-2016','%d-%m-%Y'));

-- H2
-- INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));
-- INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));
-- INSERT INTO USER (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, LASTPASSWORDRESETDATE) VALUES (3, 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'disabled@user.com', 0, PARSEDATETIME('01-01-2016','dd-MM-yyyy'));


INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);


INSERT INTO PREGUNTAS (pregunta, respuesta_uno, respuesta_dos, respuesta_tres, respuesta_cuatro, respuesta_correcta, id_examen) VALUES ('¿Qué es la programación orientada a objetos?','Permite que el código pueda ser leido en cualquier dispositivo','Es un modelo de programación que trabaja con los conceptos de clases y objetos', 'Se define como una instancia de una clase. El objeto puede tener un estado y un comportamiento','La base sobre la cual se construyen y definen los elementos para crear todo el programa',2,1);
INSERT INTO PREGUNTAS (pregunta, respuesta_uno, respuesta_dos, respuesta_tres, respuesta_cuatro, respuesta_correcta, id_examen) VALUES ('¿Qué es un objeto?','Paradigma que deja plantear una lógica para programas','Indica que una clase puede extenderse a otra','Es la capacidad de un objeto de tener una forma distinta dependiendo de la manera en que se invoque dentro del código','Se define como una instancia de una clase',4,1);
INSERT INTO PREGUNTAS (pregunta, respuesta_uno, respuesta_dos, respuesta_tres, respuesta_cuatro, respuesta_correcta, id_examen) VALUES ('¿Cuántos tipos de variables hay en Java?','Locales, Instancia, Estaticas','Public, Private, Protected','Global, General, De clase','Int, String, Boolean',1,1);
INSERT INTO PREGUNTAS (pregunta, respuesta_uno, respuesta_dos, respuesta_tres, respuesta_cuatro, respuesta_correcta, id_examen) VALUES ('¿ Cuáles son los 4 pilares de la programación orientada a objetos?','Locales, Instancia, Estaticas, Globales','Single Responsability Principle, Open/Closed Principle, Liskov Substitution Principle, Interface Segretation Principle', 'Polimorfismo, Abstracción, Herencia, Encapsulación','Public, Private, Protected, Default',3,1);

INSERT INTO EXAMEN (nombre_examen) VALUES ("Java Basico");

INSERT INTO LOCACION(ciudad, zona_horaria) VALUES ("México", "CDT");
INSERT INTO LOCACION(ciudad, zona_horaria) VALUES ("Hongkong", "WST");

INSERT INTO ESTUDIANTE (nombre, edad, id_locacion) VALUES ("Jaun Antonio González", 25, 1);
INSERT INTO ESTUDIANTE (nombre, edad, id_locacion) VALUES ("Angel Pifarrer", 30, 2);