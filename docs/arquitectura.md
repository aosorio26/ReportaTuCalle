# Arquitectura simple

El proyecto usa una arquitectura por capas:

- controller: recibe peticiones HTTP.
- service: contiene la lógica principal.
- dao: separa el acceso a datos.
- model: clases guardadas en MongoDB.
- observer: notifica cuando se registra una incidencia.
- config: contiene el ejemplo Singleton de conexión.

## Patrones usados

### DAO

La interfaz IncidenciaDao define operaciones de acceso a datos. MongoIncidenciaDao implementa esas operaciones usando MongoRepository.

### Singleton

ConexionMongoSingleton representa una configuración única de base de datos.

### Observer

Cuando se registra una incidencia, NotificadorIncidencias avisa a los observadores. AlertaMunicipalObserver imprime una alerta en consola.
