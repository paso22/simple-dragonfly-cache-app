# 📖 Simple Dragonfly Cache App

A high-performance Spring Boot application demonstrating the integration of **DragonflyDB** as a caching layer for a dictionary service, with **PostgreSQL** as the primary persistent database.

---

## 🚀 Project Overview

This project aims to provide a fast and scalable dictionary lookup service. By leveraging **DragonflyDB** (a multi-threaded Redis alternative), the application significantly reduces response times for frequently requested words by caching database results in memory.

### Key Features:
- **Fast Caching**: Seamless integration with DragonflyDB via Spring Data Redis.
- **Relational Persistence**: Word definitions are stored and managed in PostgreSQL.
- **Cache Transparency**: Responses indicate whether the data was retrieved from the cache or the database.
- **Containerized Environment**: One-click setup using Docker Compose.

---

## 🛠️ Tech Stack & Versions

| Component | Technology | Version |
| :--- | :--- | :--- |
| **Language** | Java | 25 |
| **Framework** | Spring Boot | 4.0.3 |
| **Cache Store** | DragonflyDB | Latest |
| **Database** | PostgreSQL | 17 |
| **Build Tool** | Maven | 3.x |
| **Containerization** | Docker / Docker Compose | Latest |

---

## 📋 Prerequisites

Ensure you have the following installed:
- [Java 25 JDK](https://jdk.java.net/25/)
- [Docker & Docker Compose](https://www.docker.com/products/docker-desktop/)
- [Maven](https://maven.apache.org/) (optional, if not using `mvnw`)

---

## ⚙️ Getting Started

### 1. Spin up the infrastructure
The project includes a `docker-compose.yaml` that starts DragonflyDB (port `6380`) and PostgreSQL (port `5432`).

```bash
docker-compose up -d
```

### 2. Run the application
You can run the application using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

---

## 🔌 API Documentation

### Get Word Definition
Retrieves the definition for a specific word.

**Endpoint:** `GET /dictionary/{word}`

**Example Request:**
```http
GET http://localhost:8080/dictionary/hello
```

**Example Response:**
```json
{
  "word": "hello",
  "definition": "An expression or gesture of greeting — used interjectionally in greeting, in answering the telephone, or to express surprise.",
  "source": "CACHE"
}
```
*Note: The `source` field will show `DATABASE` on the first request and `CACHE` on subsequent requests for the same word.*

---

## 🏗️ Project Structure

- `src/main/java`: Application source code (Controller, Service, Repository, Model).
- `src/main/resources`: Configuration files (`application.yml`).
- `db-init/`: SQL scripts for database initialization.
- `docker-compose.yaml`: Infrastructure setup.