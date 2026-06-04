# Library API

REST API for managing books in a library, built with Java and Spring Boot.

This project was created as a portfolio project to demonstrate backend development skills, including REST API design, database integration, Docker, validation, exception handling, pagination, and API documentation.

---

## Features

* Create a book
* List books
* Find a book by ID
* Update a book
* Delete a book
* Search books by title
* Pagination support
* Request validation
* Global exception handling
* Swagger/OpenAPI documentation

---

## Technologies

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker
* Docker Compose
* Maven
* Swagger / OpenAPI

---

## Project Structure

```text
src/main/java/com/library/library_api
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config
```

---

## Requirements

Before running the project, make sure you have installed:

* Java 21
* Docker Desktop
* Git

Maven installation is not required because the project uses Maven Wrapper.

---

# Running the Project with Docker

Build and start all containers:

```bash
docker compose up --build
```

Run containers in background:

```bash
docker compose up -d
```

Stop containers:

```bash
docker compose down
```

Check running containers:

```bash
docker ps
```

---

## Application URLs

API:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Running the Project Locally

### Start PostgreSQL

```bash
docker compose up -d postgres
```

### Build the application

Windows:

```powershell
.\mvnw.cmd clean package
```

Linux/macOS:

```bash
./mvnw clean package
```

### Run the application

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

---

# API Endpoints

| Method | Endpoint                  | Description           |
| ------ | ------------------------- | --------------------- |
| POST   | /books                    | Create a new book     |
| GET    | /books                    | List all books        |
| GET    | /books/{id}               | Find a book by ID     |
| PUT    | /books/{id}               | Update a book         |
| DELETE | /books/{id}               | Delete a book         |
| GET    | /books/search?title=value | Search books by title |

---

# Pagination

Example:

```http
GET /books?page=0&size=5
```

Parameters:

| Parameter | Description               |
| --------- | ------------------------- |
| page      | Page number (starts at 0) |
| size      | Number of items per page  |

---

# Create Book Example

Request:

```http
POST /books
Content-Type: application/json
```

Body:

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publicationYear": 2008
}
```

Response:

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "publicationYear": 2008,
  "available": true
}
```

---

# Search Example

Request:

```http
GET /books/search?title=clean
```

Response:

```json
[
  {
    "id": 1,
    "title": "Clean Code"
  }
]
```

---

# Validation

The API validates incoming requests.

Example of an invalid request:

```json
{
  "title": "",
  "author": "",
  "isbn": "",
  "publicationYear": null
}
```

Response:

```json
{
  "status": 400,
  "error": "Bad Request"
}
```

---

# Error Handling

Example of a book not found response:

```json
{
  "timestamp": "2026-05-25T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Book with ID 999 not found"
}
```

---

# Useful Commands

## Docker

```bash
docker compose up --build
docker compose up -d
docker compose down
docker ps
```

## Maven Wrapper

Windows:

```powershell
.\mvnw.cmd clean
.\mvnw.cmd package
.\mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw clean
./mvnw package
./mvnw spring-boot:run
```

---

# Future Improvements

* JWT Authentication
* Unit Tests
* Integration Tests
* GitHub Actions CI/CD
* Cloud Deployment
* Loan Management Module
* Book Categories

---

# Author

Pedro Henrique

Backend Developer Portfolio Project

If you have suggestions or feedback, feel free to open an issue or contact me through GitHub.

---
