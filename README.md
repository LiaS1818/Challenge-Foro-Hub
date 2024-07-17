# Foro-Hub API

Este proyecto es una API REST desarrollada para gestionar un foro-hub, utilizando Java 17 y Spring Boot 3. El proyecto forma parte del programa ONE de Alura Latam.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
  - spring-boot-starter-data-jpa
  - spring-boot-starter-validation
  - spring-boot-starter-web
  - spring-boot-devtools
  - spring-boot-starter-test
  - spring-boot-starter-security
- **Flyway** (flyway-core, flyway-mysql)
- **MySQL** (mysql-connector-j)
- **Lombok**
- **JWT** (java-jwt)
- **OpenAPI** (springdoc-openapi-starter-webmvc-ui)

## Instalación

1. Clonar el repositorio:

    ```sh
    git clone https://github.com/LiaS1818/Challenge-foro-hub.git
    cd Challenge-foro-hub
    ```

2. Configurar la base de datos MySQL:

    - Crear una base de datos en MySQL.
    - Configurar las credenciales de la base de datos en el archivo `application.properties`:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
      spring.datasource.username=tu_usuario
      spring.datasource.password=tu_contraseña
      ```

3. Ejecutar las migraciones de Flyway:

    ```sh
    ./mvnw flyway:migrate
    ```

4. Compilar y ejecutar la aplicación:

    ```sh
    ./mvnw spring-boot:run
    ```

## Endpoints Principales

La API proporciona los siguientes endpoints principales:

- **Autenticación** (`AutenticacionController.java`):
  - `POST /auth/login`: Autenticarse y obtener un token JWT.

- **Cursos** (`CursoController.java`):
  - `POST /cursos`: Crear un nuevo curso.
  - `GET /cursos/{id}`: Obtener detalles de un curso.
  - `PUT /cursos/{id}`: Actualizar un curso.
  - `DELETE /cursos/{id}`: Eliminar un curso.
  - `GET /cursos`: Listar todos los cursos.

- **Respuestas** (`RespuestaController.java`):
  - `POST /topicos/{topicoId}/respuestas`: Crear una nueva respuesta en un tópico.
  - `GET /topicos/{topicoId}/respuestas`: Listar respuestas de un tópico.
  - `DELETE /respuestas/{id}`: Eliminar una respuesta.

- **Tópicos** (`TopicoController.java`):
  - `POST /topicos`: Crear un nuevo tópico.
  - `GET /topicos/{id}`: Obtener detalles de un tópico.
  - `PUT /topicos/{id}`: Actualizar un tópico.
  - `DELETE /topicos/{id}`: Eliminar un tópico.
  - `GET /topicos`: Listar todos los tópicos.

## Autenticación y Seguridad

La API utiliza JWT para la autenticación y autorización. Para obtener un token JWT, los usuarios deben autenticarse a través del endpoint `/auth/login` con sus credenciales.

## Documentación de la API

La documentación completa de la API está disponible mediante OpenAPI/Swagger en el endpoint `/swagger-ui.html`.

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir, por favor, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios.
4. Haz un commit de tus cambios (`git commit -am 'Añadir nueva característica'`).
5. Sube tus cambios (`git push origin feature/nueva-caracteristica`).
6. Abre un Pull Request.

---

Proyecto desarrollado como parte del Programa ONE de Alura Latam.
