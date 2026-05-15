# Reporta Tu Calle - versión simple

Proyecto práctico para registrar incidencias en la vía pública: baches, alumbrado, basura, seguridad ciudadana y emergencia.

## Tecnologías

- Backend: Java 17, Spring Boot, Maven
- Base de datos: MongoDB
- Frontend: HTML, CSS y JavaScript simple
- Patrones: DAO, Singleton y Observer

## Ejecutar backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

MongoDB local debe estar activo en:

```text
mongodb://localhost:27017/reportatucalle
```

## Ejecutar frontend

Abrir en navegador:

```text
frontend/index.html
```

## Endpoints principales

```text
GET    /api/incidencias
POST   /api/incidencias
POST   /api/incidencias/con-archivo
PUT    /api/incidencias/{id}/estado
DELETE /api/incidencias/{id}
POST   /api/usuarios/registro
POST   /api/usuarios/login
GET    /api/info
```
