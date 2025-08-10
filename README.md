# 🍽 Recipes Orchestration API

A Spring Boot–based orchestration API that:
1. **Loads recipes** from an external dataset ([DummyJSON Recipes API](https://dummyjson.com/recipes)) into an **in-memory H2 database**.
2. Exposes REST endpoints to:
   - **Free text search** recipes by `name` or `cuisine`.
   - **Fetch a recipe** by `id`.
3. Uses **Hibernate Search** for full-text indexing.
4. Follows **clean code** practices, with logging, validation, exception handling, and proper REST standards.

---

## 📌 Features

- **Data Loading Endpoint**: Fetches all recipes from the DummyJSON API and stores them in the H2 in-memory DB.
- **Search Recipes**: Supports free text search on recipe `name` and `cuisine`.
- **Get by ID**: Fetch specific recipe details by ID.
- **Swagger/OpenAPI** documentation.
- **Resilient External Calls** using retry & timeout mechanisms.
- **Environment Layering**: Supports `dev`, `test`, and `prod` profiles.
- **Unit Tests** with high code coverage.

---

## 🛠 Tech Stack

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate Search (Lucene)**
- **H2 In-Memory Database**
- **Spring Web**
- **Spring Validation**
- **OpenAPI/Swagger** (springdoc-openapi)
- **Resilience4j** (for retries/timeouts)
- **Lombok** (for boilerplate reduction)

---

## 📂 Project Structure

<img width="635" height="846" alt="image" src="https://github.com/user-attachments/assets/2cc4cff1-2c9b-46cf-b9b3-3ff701a7b6f3" />
