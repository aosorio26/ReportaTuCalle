# Especificación de Requisitos de Software (SRS)

# Proyecto: Reporta Tu Calle

## 1. Introducción

### 1.1 Propósito

El presente documento describe los requisitos funcionales y no funcionales del sistema “Reporta Tu Calle”, una aplicación web orientada al registro y gestión de incidencias urbanas. El sistema permite a los ciudadanos reportar problemas relacionados con infraestructura pública, seguridad y servicios urbanos mediante una interfaz sencilla conectada a una base de datos.

El propósito principal del proyecto es brindar una plataforma básica de comunicación entre ciudadanos y entidades responsables, permitiendo almacenar incidencias de manera estructurada y accesible.

---

### 1.2 Alcance

El sistema “Reporta Tu Calle” permitirá registrar y observar incidencias urbanas tales como:

* Baches
* Alumbrado público dañado
* Acumulación de basura
* Problemas de seguridad
* Emergencias urbanas

## 2. Descripción General

### 2.1 Perspectiva del Producto

El sistema consiste en una aplicación cliente-servidor.

El frontend permite al usuario registrar incidencias mediante formularios simples. El backend recibe la información mediante endpoints REST y almacena los datos en MongoDB Atlas.

---

### 2.2 Funciones del Producto

Las funciones principales del sistema son:

* Registrar incidencias urbanas.
* Consultar incidencias almacenadas.
* Almacenar información en MongoDB.
* Permitir comunicación mediante API REST.
* Gestionar tipos de incidencias.
* Registrar ubicación y descripción del problema.
* Notificar eventos mediante patrón Observer.


### 2.3 Características de los Usuarios

#### Usuario

Persona encargada de registrar incidencias urbanas.

### 2.4 Restricciones

* El sistema requiere conexión a Internet para MongoDB Atlas.
* El backend debe ejecutarse con Java 17.
* Se requiere Maven para compilar el proyecto.
* MongoDB Atlas debe permitir acceso mediante IP pública. (lo configuré así)
* El frontend funciona sobre navegador web.

---

# 3. Requisitos Funcionales

## RF-01 Registro de Usuario
El sistema debe permitir registrar al usuario que subirá el incidente
Los datos son:
* Nombre
* Correo
* Contraseña


## RF-01 Login de Usuario
El sistema debe permitir el acceso del usuario registrado
* Correo
* Contraseña


## RF-03 Registro de Incidencias
El sistema debe permitir registrar incidencias urbanas mediante un formulario web.
Los datos son:
* Título
* Descripción
* Ubicación
* Tipo de incidencia
* Archivo (imagen,video)
* El nombre del usuario que lo registra

## RF-04 Actualizar Lista

El sistema debe permitir visualizar todas las incidencias mediante un único botón de actualización
Esto se hace con el patrón observador que aprendimos en clase

---






