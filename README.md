# examen
Prueba de aplicacion de examen
**para la creacion de la base de datos solamente es necesario crear una base de datos MySQL, ejemplo:**

create database pruebatecnica;
use pruebatecnica;

**Las tablas se generan automáticamente y cuenta con un archivo import.sql que hace la carga inicial de datos**

**Configurar el archivo application.yml con los datos para base de datos MySQL**

**Configurar el buildpath para java jdk 1.8 (en caso de ser necesario)**

**Construir el proyecto con mvn clean install**

**Cada vez que se ejecuta la aplicación como Springoot App, las tablas se borran y se vuelven a generar con la información inicial**

**Usuarios para crear token**
	Rol usuario:
		username: user
		password : password	
	
	Rol administrador
		username: admin
		password : admin
	
**Se comparte una colección de postman con request para prueba**
