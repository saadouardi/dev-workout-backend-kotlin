# Kotlin + Spring Boot Developer Challenge

This repository is a **fork of the Micromerce backend developer challenge**. I used the provided starting point and implemented improvements on my own branch to practice API design, Kotlin, Spring Boot, and backend engineering decisions.

> **My work is on the `saad/improvements` branch**, which is also configured as the default branch of this fork.

## Tech stack

- Kotlin
- Spring Boot
- Gradle
- REST APIs
- Docker

## What I worked on

- Reviewed and improved REST endpoint design
- Added clearer backend structure and configuration
- Improved CORS handling for local frontend integration
- Evaluated production-readiness gaps
- Connected the backend to the React + TypeScript challenge frontend
- Deployed the backend for integration testing

## API

Example products endpoint:

https://dev-workout-backend-kotlin.onrender.com/products

Run locally:

```bash
./gradlew bootRun
```

The backend runs on:

```text
http://localhost:8080
```

## REST design improvements

The original cart routes were functional but action-oriented. A more REST-oriented design would use:

```text
GET    /cart
POST   /cart/items
PATCH  /cart/items/{productId}
DELETE /cart/items/{productId}
DELETE /cart
```

This makes resources and HTTP semantics clearer and improves frontend integration.

## Production improvements I would add

- Environment-specific configuration
- Structured logging and monitoring
- Request validation and consistent error handling
- Authentication / authorization where required
- Unit and integration tests
- OpenAPI documentation
- Persistent database storage
- CI/CD
- Restrictive production CORS configuration

## Related frontend

[React + TypeScript challenge](https://github.com/saadouardi/dev-workout-react-typescript)

## Author

**Saad Ouardi**  
[Portfolio](https://saadouardi.vercel.app) · [LinkedIn](https://www.linkedin.com/in/saad-ouardi)
