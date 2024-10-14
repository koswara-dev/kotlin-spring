# REST API CRUD with Kotlin, Spring Boot 3, H2 Database, JPA, and Validation

This project is a simple RESTful API built with Kotlin and Spring Boot 3 that demonstrates CRUD operations using an H2 in-memory database, JPA for data persistence, and validation for input data.

## Features

- CRUD operations (Create, Read, Update, Delete)
- In-memory H2 database for quick setup and testing
- JPA for entity management and database interaction
- Input validation using `javax.validation` annotations (e.g., `@NotNull`, `@Size`, etc.)
- Exception handling for validation errors and other cases
- Pagination and sorting for querying data

## Prerequisites

To run this project locally, you need:

- Java 17 or later
- Kotlin 1.8 or later
- Maven or Gradle
- An IDE such as IntelliJ IDEA (recommended) or Eclipse

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/koswara-dev/kotlin-spring.git
cd kotlin-spring
```

### Build and Run

You can build the project using Maven or Gradle.

#### Using Maven

```bash
./mvnw spring-boot:run
```

#### Using Gradle

```bash
./gradlew bootRun
```

### Accessing the API

Once the application is running, you can access the API at:

- Base URL: `http://localhost:8080/api`

### API Endpoints

The following CRUD endpoints are available for the resource (e.g., `items`):

| Method | Endpoint            | Description                       | Body (JSON)                                  |
|--------|---------------------|-----------------------------------|----------------------------------------------|
| GET    | `/api/items`         | Retrieve a list of all items      | -                                            |
| GET    | `/api/items/{id}`    | Retrieve a specific item by ID    | -                                            |
| POST   | `/api/items`         | Create a new item                 | `{"name": "Item Name", "price": 10.0}`       |
| PUT    | `/api/items/{id}`    | Update an existing item by ID     | `{"name": "Updated Name", "price": 15.0}`    |
| DELETE | `/api/items/{id}`    | Delete an item by ID              | -                                            |

### Request Body Validation

The project includes validation for API request bodies using JPA and validation annotations such as:

- `@NotNull` - Ensures a field is not null.
- `@Size(min, max)` - Ensures a field meets size requirements.
- `@Min(value)` - Ensures a field has a minimum value.

If a request body does not meet the validation criteria, the API will return a `400 Bad Request` with detailed error messages.

### Pagination and Sorting

You can paginate and sort the list of items using query parameters:

- `GET /api/items?page=0&size=10&sort=name,asc`

### H2 Database Console

To access the H2 database console, go to `http://localhost:8080/h2-console`. The default JDBC URL is:

```
jdbc:h2:mem:testdb
```

### Project Structure

```
src/
└── main/
    ├── kotlin/               # Kotlin source code
    │   └── com/example/demo/ # Main package
    │       ├── controller/   # REST controllers
    │       ├── model/        # JPA entities and DTOs
    │       ├── repository/   # JPA repositories
    │       └── service/      # Business logic
    └── resources/
        ├── application.yml   # Application configuration
        └── data.sql          # Sample data for initialization
```

### Running Tests

To run the tests, use the following command:

#### Using Maven

```bash
./mvnw test
```

#### Using Gradle

```bash
./gradlew test
```

## Buy me a coffe

If you like this project and want to support its further development, buy me a coffee!

[![Buy Me a Coffee](https://www.buymeacoffee.com/assets/img/guidelines/download-assets-sm-1.svg)](https://www.buymeacoffee.com/kudajengke404)