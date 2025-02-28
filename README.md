# Translation Management Service

## Overview
The Translation Management Service is a Spring Boot-based API-driven service that allows managing translations for multiple locales. It supports creating, updating, viewing, and searching translations efficiently while following best coding practices, including SOLID principles, optimized SQL queries, and secure authentication.

## Features
- Store translations for multiple locales (e.g., `en`, `fr`, `es`).
- Add new languages dynamically.
- Tag translations for context (e.g., `mobile`, `desktop`, `web`).
- Expose endpoints for CRUD operations.
- Search translations by tags, keys, or content.
- Provide a JSON export endpoint for frontend applications.
- Ensure responses within **200ms** and export within **500ms**.
- Seed database with **100k+ records** for scalability testing.
- Implement token-based authentication for security.

## Tech Stack
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **/PostgreSQL** (Configurable Database)
- **Spring Security** (Token-based Authentication)

## Installation
### Prerequisites
- Java 17 or later
- Maven
- PostgreSQL (optional for production use)

### Setup & Run
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/translation-service.git
   cd translation-service
   ```
2. Configure database in `application.properties` (for PostgreSQL):
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
   spring.datasource.username=postgres
   spring.datasource.password=2818
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints
### Authentication
- **Login (Obtain Token):** `POST /api/auth/login`
- **Secure all endpoints with Bearer Token Authentication**

### Translation Operations
- **Create Translation:** `POST /api/translate`
- **Search Translations:** `GET /api/translations?tag=web&text=hello&language=en`
- **Export Translations:** `GET /api/translations/export?page=0&size=1000`

## Performance Optimization
- **Indexing:** Optimized queries using indexed columns for `language`, `text`, and `tag`.
- **Pagination:** Export endpoint supports paginated requests.
- **Asynchronous Processing:** Background tasks are handled efficiently.

## Security Measures
- **Token-based Authentication (JWT)**
- **Input Validation & SQL Injection Prevention**
- **Secure HTTP Headers**

## Database Seeder
A command to populate **100k+ records** is included and runs automatically on startup if the database is empty.

## Future Enhancements
- Add caching for frequently accessed translations.
- Support for additional export formats (CSV, XML).
- Role-based access control (RBAC).

