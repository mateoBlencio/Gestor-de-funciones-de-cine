# Gestor de funciones cinematograficas

## Descripción
Este proyecto es un conjunto de microservicios desarrollados con Spring Framework y MySQL que trabajan juntos para proporcionar una plataforma para la gestión de películas, funciones de cine y tickets para estas funciones.

## Tecnologías Utilizadas
Lista de las principales tecnologías y frameworks utilizados en el proyecto.
- Spring Framework
- Spring Cloud
- MySQL
- Maven
- Hibernate
- Resilence4j
- Boostrap
- Eureka
- Lombok
- OpenFeign

## Funcionalidades Principales
Registro y gestión de películas
Programación y gestión de funciones de cine
Gestión de salas de cine y asientos

## Estructura del proyecto
El proyecto consta de varios microservicios, incluyendo:

Peliculas-Service: Gestiona la información relacionada con las películas.

Funciones-Service: Administra las funciones de cine y la programación.

Tickets-Service: Administra la obtencion y creacion de tickets para una determinada funcion.

Api-Gateway: Actúa como punto de entrada único para todas las solicitudes al sistema.

Config-Service:  Simplifica la gestión de la configuración en un entorno de microservicios al proporcionar una única fuente de verdad para la configuración de la aplicación

Eureka-Service: Proporciona un mecanismo centralizado para el registro y descubrimiento de servicios en un entorno de microservicios.

## Endpoints por microservicio

### Peliculas-service
| Entidad              | Método | Endpoint                         | Descripción                                                                   |
|----------------------|--------|----------------------------------|-------------------------------------------------------------------------------|
| CalificacionPelicula | GET    | `/peliculas/calificaciones`      | Obtener información de todos las calificaciones de las peliculas              |
|                      | POST   | `/peliculas/calificaciones`      | Crear una nueva calificacion                                                  |
|                      | PUT    | `/peliculas/calificaciones/{id}` | Actualizar el nombre de una calificacion                                      |
|                      | DELETE | `/peliculas/calificaciones/{id}` | Eliminar una calificacion                                                     |
| CategoriaPelicula    | GET    | `/peliculas/categorias`          | Obtener información de todas las categorías de películas.                     |
|                      | POST   | `/peliculas/categorias`          | Crear una nueva categoría de película.                                        |
|                      | DELETE | `/peliculas/categorias/{id}`     | Eliminar una categoría de película existente.                                 |
|                      | PUT    | `/peliculas/categorias/{id}`     | Actualizar una categoría de película existente.                               |
| EstadoPelicula       | GET    | `/peliculas/estados`             | Obtener información de todos los estados de películas.                        |
|                      | POST   | `/peliculas/estados`             | Crear un nuevo estado de película.                                            |
|                      | DELETE | `/peliculas/estados/{id}`        | Eliminar un estado de película existente.                                     |
|                      | PUT    | `/peliculas/estados/{id}`        | Actualizar un estado de película existente.                                   |
| Pelicula             | GET    | `/peliculas/peliculas`           | Obtener información de todas las películas.                                   |
|                      | GET    | `/peliculas/peliculas/{id}`      | Obtener información de una película específica.                               |
|                      | GET    | `/peliculas/peliculas/cartelera` | Obtener información de las películas actualmente en cartelera.                |
|                      | POST   | `/peliculas/peliculas`           | Crear una nueva película.                                                     |
|                      | DELETE | `/peliculas/peliculas/{id}`      | Eliminar una película existente si esta no esta en cartelera ni proximamente. |
|                      | PATCH  | `/peliculas/peliculas/{id}`      | Actualizar estado de una película existente.(cambiar al siguiente)            |

### Funciones-service
| Entidad    | Método | Endpoint                         | Descripción                                                     |
|------------|--------|----------------------------------|-----------------------------------------------------------------|
| EstadoSala | GET    | `/funciones/estadossalas`        | Obtener información de todos las estados de las salas.          |
|            | POST   | `/funciones/estadossalas`        | Crear una nueva sala.                                           |
|            | PUT    | `/funciones/estadossalas/{id}`   | Actualizar informacion sobre una sala existente.                |
|            | DELETE | `/funciones/estadossalas/{id}`   | Eliminar una sala.                                              |
| Funciones  | GET    | `/funciones/funciones`           | Obtener información de todas las funciones.                     |
|            | GET    | `/funciones/funciones/{id}`      | Obtener información de una funcion existente.                   |
|            | GET    | `/funciones/funciones/cartelera` | Obtener información de las funciones de peliculas en cartelera. |
|            | POST   | `/funciones/funciones`           | Crear una nueva funcion de película.                            |
|            | DELETE | `/funciones/funciones/{id}`      | Eliminar una funcion existente.                                 | 
|            | PUT    | `/funciones/funciones/{id}`      | Actualizar una funcion existente.                               |
| Salas      | GET    | `/funciones/salas`               | Obtener información de todas las salas.                         |
|            | POST   | `/funciones/salas`               | Crear una nueva sala.                                           |
|            | DELETE | `/funciones/salas/{id}`          | Eliminar una sala existente.                                    |
|            | PUT    | `/funciones/salas/{id}`          | Actualizar una sala existente.                                  |
| TipoSala   | GET    | `/funciones/tipossalas`          | Obtener información de todos los tipos de salas.                |
|            | POST   | `/funciones/tipossalas`          | Crear un nuevo tipo de sala.                                    |
|            | DELETE | `/funciones/tipossalas/{id}`     | Eliminar un tipo de sala existente.                             |
|            | PUT    | `/funciones/tipossalas/{id}`     | Actualizar un tipo de sala existente.                           |

### Tickets-service
| Entidad | Método | Endpoint                       | Descripción                                                       |
|---------|--------|--------------------------------|-------------------------------------------------------------------|
| Tickets | GET    | `/tickets/tickets`             | Obtener información de todos los tickets.                         |
|         | GET    | `/tickets/tickets/{funcionID}` | Obtener información de los tickets de una determinada funcion.    |
|         | POST   | `/funciones/estadossalas/{id}` | Crear un nuevo ticket para una funcion con pelicula en cartelera. |
