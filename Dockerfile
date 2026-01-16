# ---- Build stage ----
FROM gradle:8.10-jdk17 AS build
WORKDIR /app

COPY . .
RUN gradle build -x test

# ---- Run stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

# Render sets PORT; fallback to 8080
ENV PORT=8080
EXPOSE 8080

CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
