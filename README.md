<div align="center">

#  TecnoStore — API REST  
**Sistema de Gestión de Ventas con Spring Boot 🛒**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![JPA](https://img.shields.io/badge/JPA/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

---

**MARÍA ALEJANDRA GÓMEZ ARCHILA**  
**2026 - Proyecto Spring Boot + REST API + JWT**

![Spring Boot + MySQL](https://img.shields.io/badge/Spring_Boot_%2B_MySQL-Powered-success?style=for-the-badge&logo=springboot&labelColor=6DB33F)

</div>

---

##  Descripción General

**TecnoStore API** es una **API REST profesional** desarrollada con Spring Boot, que gestiona productos y ventas para una tienda de tecnología. Evoluciona el proyecto consola anterior hacia una arquitectura moderna orientada a servicios web, con seguridad JWT y documentación OpenAPI.

El sistema permite:

-  Gestión completa de productos (CRUD) con validaciones
-  Registro y consulta de ventas con detalle de líneas
-  Autenticación segura mediante JWT
-  Documentación interactiva con Swagger UI
-  Soporte CORS para integración con frontends

> **Proyecto académico que demuestra dominio de Spring Boot, JPA/Hibernate, Spring Security, JWT y arquitectura REST en capas.**

---

##  Características Principales

|  Módulo |  Funcionalidades |
|-----------|------------------|
| **Gestión de Productos** | CRUD completo: crear, actualizar, eliminar, listar y buscar por ID |
| **Gestión de Ventas** | Registro de ventas con fecha, total y detalle de productos |
| **Detalle de Venta** | Relación `ManyToOne` con `Venta` y `Producto`, cantidad y subtotal |
| **Autenticación JWT** | Login con credenciales, generación y validación de token |
| **Seguridad** | Spring Security stateless, filtro JWT personalizado, CORS configurado |
| **DTOs y Mappers** | Separación de entidades y capa de transferencia de datos |
| **Excepciones** | `BusinessRuleException` + `GlobalExceptionHandler` con respuestas JSON |
| **Documentación** | Swagger UI vía SpringDoc OpenAPI 2.x |

---

##  Tecnologías Utilizadas

```mermaid
graph LR
    A[Lenguaje] --> Java_17
    B[Framework] --> Spring_Boot_3.5
    C[Persistencia] --> JPA_Hibernate
    D[Base de Datos] --> MySQL_8
    E[Seguridad] --> Spring_Security
    E --> JWT_jjwt_0.11
    F[Documentación] --> SpringDoc_OpenAPI
    G[Utilidades] --> Lombok
```

###  Stack Tecnológico

- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3.5.11
- **Persistencia:** Spring Data JPA + Hibernate (`ddl-auto=none`)
- **Base de Datos:** MySQL 8.0
- **Seguridad:** Spring Security + JWT (`jjwt 0.11.5`)
- **Documentación:** SpringDoc OpenAPI 2.8.15 (Swagger UI)
- **Utilidades:** Lombok
- **Build:** Maven (Maven Wrapper incluido)

---

##  Instalación y Uso

Sigue estos pasos para ejecutar el proyecto localmente:

###  Requisitos Previos

-  Java JDK 17 o superior
-  MySQL 8.0 o superior
-  IDE de Java (recomendado: IntelliJ IDEA)
-  Maven (o usar el wrapper `./mvnw` incluido)

###  Pasos de Instalación

```bash
# 1. Clonar el repositorio
git clone https://github.com/gamaz-19/SpringBoot_GomezMaria.git

# 2. Entrar al directorio del proyecto
cd SpringBoot_GomezMaria

# 3. Crear la base de datos en MySQL
mysql -u root -p -e "CREATE DATABASE gestion_ventas;"
```

###  Configurar Conexión a MySQL

Edita el archivo `src/main/resources/application.properties` con tus credenciales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_ventas
spring.datasource.username=root
spring.datasource.password=tu_password
```

###  Compilar y Ejecutar

```bash
# Opción 1: Maven Wrapper (sin instalación previa)
./mvnw spring-boot:run

# Opción 2: Maven instalado
mvn spring-boot:run

# Opción 3: Desde IDE
# Abre el proyecto y ejecuta VentasGstionApplication.java
```

La API estará disponible en: `http://localhost:8080`  
Swagger UI disponible en: `http://localhost:8080/swagger-ui.html`

---

##  Estructura del Proyecto

```
 SpringBoot_GomezMaria/
├──  src/main/java/com/s1/ventasGstion/
│   ├── VentasGstionApplication.java       # Punto de entrada de Spring Boot
│   │
│   ├──  auth/
│   │   ├── Authcontroller.java            # Endpoint POST /auth/login
│   │   ├── LoginRequest.java              # Record con username y password
│   │   └── LoginResponse.java             # Respuesta con token JWT
│   │
│   ├──  config/
│   │   ├── JwtFilter.java                 # Filtro: valida JWT en cada request
│   │   ├── JwtService.java                # Generación y validación de tokens
│   │   ├── OpenAPIConfig.java             # Configuración Swagger UI
│   │   └── SecurityConfig.java            # Seguridad stateless + CORS
│   │
│   ├──  controller/
│   │   ├── ProductoController.java        # CRUD /api/producto
│   │   └── VentaController.java           # CRUD /api/venta
│   │
│   ├──  dto/
│   │   ├──  request/
│   │   │   ├── ProductoRequestDTO.java
│   │   │   ├── VentaRequestDTO.java
│   │   │   └── DetalleVentaRequestDTO.java
│   │   └──  response/
│   │       ├── ProductoResponseDTO.java
│   │       ├── VentaResponseDTO.java
│   │       ├── DetalleVentaResponseDTO.java
│   │       └── NombreDetalleVentaProductoResponseDTO.java
│   │
│   ├──  exception/
│   │   ├── BusinessRuleException.java     # Excepción de negocio personalizada
│   │   ├── ErrorResponse.java             # Estructura de error JSON
│   │   └── GlobalExceptionHandler.java    # Manejo global de excepciones
│   │
│   ├──  mapper/
│   │   ├── ProductoMapper.java
│   │   ├── VentaMapper.java
│   │   └── DetalleVentaMapper.java
│   │
│   ├──  model/
│   │   ├── Producto.java                  # Entidad: id, nombre, descripcion, precio, stock
│   │   ├── Venta.java                     # Entidad: id, fecha, total
│   │   └── DetalleVenta.java              # Entidad: cantidad, subtotal, FK venta y producto
│   │
│   ├──  repository/
│   │   ├── ProductoRepository.java
│   │   ├── VentaRepository.java
│   │   └── DetalleVentaRepository.java
│   │
│   └──  service/
│       ├── ProductoService.java           # Interfaz
│       ├── VentaService.java              # Interfaz
│       ├── DetalleVentaService.java       # Interfaz
│       └──  impl/
│           ├── ProductoServiceImpl.java
│           ├── VentaServiceImpl.java
│           └── DetalleVentaServiceImpl.java
│
├──  src/main/resources/
│   └── application.properties             # Configuración de BD y JPA
│
├── pom.xml                                # Dependencias Maven
└── mvnw / mvnw.cmd                        # Maven Wrapper
```

---

##  Base de Datos MySQL

### Estructura de Tablas

El sistema utiliza **3 tablas relacionales** con integridad referencial:

####  Diagrama de Relaciones

```
┌───────────┐         ┌───────────────┐         ┌───────────────┐
│  producto │────<    │ detalle_venta │    >────│     venta     │
└───────────┘         └───────────────┘         └───────────────┘
```

####  Tablas Principales

| Tabla | Descripción | Campos Clave |
|-------|-------------|--------------|
| **producto** | Catálogo de productos | `id` (PK), `nombre`, `descripcion`, `precio`, `stock` |
| **venta** | Cabecera de cada venta | `id` (PK), `fecha`, `total` |
| **detalle_venta** | Líneas de cada venta | `id` (PK), `venta_id` (FK), `producto_id` (FK), `cantidad`, `subtotal` |

>  La propiedad `spring.jpa.hibernate.ddl-auto=none` indica que las tablas deben crearse manualmente en MySQL antes de ejecutar la aplicación.

---

##  Seguridad y Autenticación JWT

### Flujo de Autenticación

```
1. Cliente  →  POST /auth/login  →  { username: "admin", password: "1234" }
2. Servidor →  Genera JWT Token  →  { "token": "eyJhbGci..." }
3. Cliente  →  Incluye header    →  Authorization: Bearer eyJhbGci...
4. JwtFilter→  Valida token      →  Permite o deniega acceso
```

### Endpoints Públicos (sin token)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/auth/login` | Obtener token JWT |
| `GET`  | `/api/persona/public/**` | Endpoints públicos de persona |

### Endpoints Protegidos (requieren Bearer Token)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/producto` | Crear producto |
| `GET` | `/api/producto` | Listar todos los productos |
| `GET` | `/api/producto/{id}` | Buscar producto por ID |
| `PUT` | `/api/producto/{id}` | Actualizar producto |
| `DELETE` | `/api/producto/{id}` | Eliminar producto |
| `POST` | `/api/venta` | Registrar venta |
| `GET` | `/api/venta` | Listar todas las ventas |
| `GET` | `/api/venta/{id}` | Buscar venta por ID |
| `PUT` | `/api/venta/{id}` | Actualizar venta |

---

##  Ejemplo de Uso con la API

### 1 Obtener Token JWT

```http
POST http://localhost:8080/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "1234"
}
```

**Respuesta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 2 Crear un Producto

```http
POST http://localhost:8080/api/producto
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
Content-Type: application/json

{
  "nombre": "Samsung Galaxy S24",
  "descripcion": "Smartphone Android gama alta",
  "precio": 4500000,
  "stock": 15
}
```

**Respuesta `201 Created`:**
```json
{
  "id": 1,
  "nombre": "Samsung Galaxy S24",
  "descripcion": "Smartphone Android gama alta",
  "precio": 4500000,
  "stock": 15
}
```

### 3 Registrar una Venta

```http
POST http://localhost:8080/api/venta
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
Content-Type: application/json

{
  "fecha": "2026-03-19",
  "total": 9000000
}
```

**Respuesta `201 Created`:**
```json
{
  "id": 1,
  "fecha": "2026-03-19",
  "total": 9000000
}
```

---

## Arquitectura y Patrones Aplicados

### Arquitectura en Capas

| Capa | Paquete | Responsabilidad |
|------|---------|-----------------|
| **Controller** | `controller/` | Recibe requests HTTP, devuelve ResponseEntity |
| **Service** | `service/` + `service/impl/` | Lógica de negocio, operaciones CRUD |
| **Repository** | `repository/` | Acceso a datos con Spring Data JPA |
| **Model** | `model/` | Entidades JPA mapeadas a tablas MySQL |
| **DTO** | `dto/` | Objetos de transferencia de datos (Request/Response) |
| **Mapper** | `mapper/` | Conversión entre entidades y DTOs |
| **Config** | `config/` | Configuración de seguridad, JWT y OpenAPI |

### Principios SOLID Aplicados

| Principio | Aplicación en el proyecto |
|-----------|--------------------------|
| **S** - Single Responsibility | Cada clase tiene una única responsabilidad: Controller (HTTP), Service (lógica), Repository (datos) |
| **O** - Open/Closed | Interfaces `ProductoService`, `VentaService` permiten nuevas implementaciones sin modificar existentes |
| **L** - Liskov Substitution | `ProductoServiceImpl` implementa `ProductoService` y puede sustituirla sin romper el sistema |
| **I** - Interface Segregation | Interfaces de servicio exponen solo los métodos necesarios por entidad |
| **D** - Dependency Inversion | Los Controllers dependen de interfaces Service, no de implementaciones concretas |

### Manejo de Excepciones

```java
// Lanzamiento en capa de negocio
throw new BusinessRuleException("Credenciales inválidas");

// Respuesta automática en formato JSON
{
  "error": "Credenciales inválidas",
  "status": 400
}
```

---

##  Conceptos Aplicados

### Spring Boot y JPA
- Inyección de dependencias con `@RequiredArgsConstructor` (Lombok)
- Mapeo ORM con `@Entity`, `@ManyToOne`, `@JoinColumn`
- Repositorios con `JpaRepository` (findAll, findById, save, deleteById)
- Uso de `Optional` con `orElseThrow()` para manejo seguro de nulos

### Seguridad
- Configuración stateless (`SessionCreationPolicy.STATELESS`)
- Filtro personalizado `JwtFilter` que intercepta cada request
- Configuración CORS para orígenes `localhost:5500` y `127.0.0.1:5500`
- Desactivación de CSRF para APIs REST

### DTOs y Mappers
- Separación completa entre capa de persistencia y capa de presentación
- DTOs de Request para entrada y DTOs de Response para salida
- Mappers dedicados para conversión entidad ↔ DTO

---

##  Autora

<div align="center">

|  Nombre |  Rol |  GitHub |
|--------|-----|--------|
| **María Alejandra Gómez Archila** | Full Stack Developer | [@gamaz-19](https://github.com/gamaz-19) |

</div>

---

##  Licencia

Este proyecto es de código abierto con fines educativos.  
Desarrollado como proyecto académico para demostrar competencias en:

-  Spring Boot 3 y arquitectura REST
-  Seguridad con Spring Security y JWT
-  Persistencia con JPA/Hibernate y MySQL
-  Patrones de diseño y arquitectura en capas
-  Documentación de APIs con OpenAPI / Swagger

---

<div align="center">

**TecnoStore API • 2026**

[![Java](https://img.shields.io/badge/Made_with-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Framework-Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/Database-MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com)

</div>
