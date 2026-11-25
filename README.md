# Product Management System

A RESTful Product Management API built with Java, Spring Boot, and Spring Data JPA. This project demonstrates CRUD operations, database integration, custom exception handling, and centralized error responses.

## Features

- **Create Products** – Add new products to the database.
- **Retrieve Products** – Fetch products by ID or retrieve all products.
- **Update Products** – Update existing product information.
- **Delete Products** – Delete products by ID.
- **Custom Exception Handling** – Handle application-specific exceptions such as `ProductNotFoundException` and `DuplicateProductException`.
- **Global Exception Handling** – Centralize exception handling using `@RestControllerAdvice` and `@ExceptionHandler`.
- **Structured Error Responses** – Return consistent error information through a custom `ErrorResponse` model.
- **HTTP Status Codes** – Use appropriate HTTP status codes, such as `200 OK`, `404 NOT FOUND`, and `409 CONFLICT`.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.2.0 | Application framework |
| Spring Web MVC | REST API development |
| Spring Data JPA | Database access and persistence |
| MySQL | Relational database |
| Hibernate | ORM |
| Maven | Dependency management and build automation |
| Lombok | Reduce boilerplate code |

## Architecture

The application follows a layered architecture to separate responsibilities and improve maintainability.

```text
Client (Postman)
       |
       v
Controller Layer
       |
       v
Service Layer
       |
       v
Repository Layer
       |
       v
MySQL Database
```

**Exception Handling Flow:**

```text
Service Layer
      |
      | Throws Custom Exception
      v
Controller Layer
      |
      | Exception propagates
      v
Global Exception Handler
(@RestControllerAdvice)
      |
      v
ErrorResponse
      |
      v
HTTP Error Response
```

### Exception Handling

The application uses custom exceptions to handle specific business scenarios.

Examples:
- `ProductNotFoundException` – Thrown when a requested product does not exist.
- `DuplicateProductException` – Thrown when attempting to create a duplicate product.

A centralized exception handler uses `@RestControllerAdvice` and `@ExceptionHandler` to catch exceptions and return appropriate HTTP responses.

The `ErrorResponse` model provides a consistent error response structure:

| Field | Description |
|---|---|
| `timeStamp` | Time when the error occurred |
| `errorMessage` | Error message |
| `errorDetails` | Additional request details |
| `errorCode` | Application-specific error code |

