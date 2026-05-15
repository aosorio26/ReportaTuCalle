# Readme del examen parcial


## Tecnologías que se usaron
- Backend: Java 17, Spring Boot, Maven
- Base de datos: MongoDB
- Frontend: HTML, CSS y JavaScript simples porque me enfoqué más en los patrones
- Patrones: DAO, Singleton y Observer

##  Para ejecutar
Se abre la terminal en la carpeta del proyecto
cd backend
mvn clean install
mvn spring-boot:run
Debe salir que mongodb está activo

mongodb://localhost:27017/reportatucalle

## Para el frontend

Abrir en navegador con open with live server el siguiente archivo:

frontend/index.html

## Lista de endpoints para pruebas

GET    /api/incidencias
POST   /api/incidencias
POST   /api/incidencias/con-archivo
PUT    /api/incidencias/{id}/estado
DELETE /api/incidencias/{id}
POST   /api/usuarios/registro
POST   /api/usuarios/login
GET    /api/info

