# Casos de prueba realizados

| Código | Caso | Entrada | Resultado esperado |
|---|---|---|---|
| CP01 | Registrar bache | título, descripción, tipo BACHE, dirección | Se guarda con estado REPORTADO |
| CP02 | Listar reportes | GET /api/incidencias | Retorna lista JSON |
| CP03 | Cambiar estado | PUT con estado EN_PROCESO | Se actualiza el reporte |
| CP04 | Subir evidencia | archivo imagen/video/audio | Se guarda el nombre del archivo |
| CP05 | Login usuario | correo y clave | Retorna ok true o false |

También se agregaron pruebas unitarias para servicio, observer y singleton.
