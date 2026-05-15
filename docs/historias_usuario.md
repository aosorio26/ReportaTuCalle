# Historias de usuario

## Historia 1: Registrar incidencia

Como vecino, quiero registrar un problema en mi calle para que la municipalidad pueda revisarlo.

Criterios:
- Debo ingresar título, descripción, tipo y dirección.
- Puedo adjuntar una evidencia.
- El reporte inicia con estado REPORTADO.

## Historia 2: Consultar incidencias

Como trabajador municipal, quiero ver los reportes registrados para revisar qué problemas existen.

Criterios:
- El sistema muestra una lista de reportes.
- Cada reporte muestra tipo, dirección y estado.

## Historia 3: Actualizar estado

Como trabajador municipal, quiero cambiar el estado de una incidencia para indicar su avance.

Criterios:
- Se puede cambiar a ASIGNADO, EN_PROCESO o RESUELTO.
- El cambio queda guardado en MongoDB.
