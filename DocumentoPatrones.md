# Arquitectura del Sistema reportatucalle
La arquitectura del backend está dividida en varias capas:

Controller, Service, Dao, Base de Datos

El Controller recibe las solicitudes del frontend. Luego llama al Service, donde se encuentra la lógica principal del sistema después, el Service utiliza el DAO para guardar o consultar información en MongoDB.

1. Se utilizó el patrón DAO para separar la lógica de acceso a datos de la lógica del sistema. Esto ayuda a mantener el código más ordenado y facilita cambios futuros.

2. Se implementó el patrón Singleton para manejar una configuración centralizada relacionada con la base de datos. 

3. Se utilizó el patrón Observer para notificar cuando se registra una nueva incidencia. 

Frontend y el backend separados para mantener el sistema más organizado. .

El frontend fue implementado usando HTML, CSS y JavaScript de manera simple. Desde ahí el usuario puede registrar incidencias urbanas como baches, basura, problemas de alumbrado o emergencias. Se hubiera deseado usar un framework para hacer más bonito el frontend pero por motivos de tiempo se concentro más en patrones de desarrollo.

El backend fue desarrollado con Spring Boot, maven y funciona mediante una API REST. El frontend envía peticiones HTTP al backend para registrar o consultar incidencias.

La base de datos utilizada fue MongoDB Atlas, con objetos JSON.
