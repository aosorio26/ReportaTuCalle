# Readme del examen parcial
Estimado profesor, para los documentos (breves) y para las evidencias (pantallazo de las pruebas de uso, entre a la carpeta docs)

## Tecnologías que usé para el parcial
- para el backend: Java 17, Spring Boot, Maven
- para la base de datos: MongoDB (Atlas, no el local, la URI está ubicada en backend/src/main/java/resources/application.properties
- Frontend: HTML, CSS y JavaScript simples porque me enfoqué más en los patrones
- Patrones: DAO, Singleton y Observer (DAO es la estructura general, singleton es para la BD, observer para el reporte de incidencias)

##  como se ejecuta
Terminal en la carpeta principal y luego las siguientes instrucciones:
cd backend
mvn clean install
mvn spring-boot:run
Debe salir que mongodb está activo, porque lo configuré para que cualquier IP pueda ingresar

mongodb://localhost:27017/reportatucalle

## Para el frontend
Abrir en navegador con open with live server el siguiente archivo:
frontend/index.html
Es directo en html

## Lista de endpoints para pruebas

GET    /api/incidencias //
POST   /api/incidencias //
POST   /api/incidencias/con-archivo //
PUT    /api/incidencias/{id}/estado //
DELETE /api/incidencias/{id} //
POST   /api/usuarios/registro //
POST   /api/usuarios/login //

