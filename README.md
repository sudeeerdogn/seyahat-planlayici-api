# Seyahat Planlayici API

Spring Boot ile gelistirilmis, JWT tabanli kimlik dogrulamaya sahip bir Travel Planner backend projesi.

## Tech Stack
- Java 23
- Spring Boot 3.5.x
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI
- Maven + GitHub Actions

## Core Features
- Kullanici kaydi ve girisi (`/api/auth`)
- Destinasyon CRUD + arama/filtreleme
- Trip olusturma ve destinasyona gore listeleme
- Global exception handling ile standart hata cevabi
- Health endpoint (`/actuator/health`) ile monitor destegi

## Project Structure
```text
src/main/java/com/seyahat_planlayici
|- config
|- controller
|- exception
|- model
|- repository
`- service
```

## Environment Variables
`.env.example` dosyasini kopyalayip kendi degerlerinle doldur:

```bash
cp .env.example .env
```

Kullanilan degiskenler:
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `PORT`
- `CORS_ALLOWED_ORIGINS`
- `JWT_SECRET`
- `JWT_EXPIRATION_MS`

## Run Locally
1. PostgreSQL'de `seyahat_db` adinda veritabani olustur.
2. Gerekirse kullanici olustur:
   - username: `seyahat_user`
   - password: `seyahat123`
3. Projeyi calistir:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

API base URL: `http://localhost:8080`

## API Documentation
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Health Check (UptimeRobot)
- Endpoint: `GET /actuator/health`
- Beklenen cevap:

```json
{"status":"UP"}
```

Public deploy sonrasi UptimeRobot'a su URL'i ekleyebilirsin:
- `https://<your-backend-domain>/actuator/health`

## Error Response Format
Tum hatalar tutarli bir JSON formatinda doner:

```json
{
  "timestamp": "2026-04-14T11:20:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "path": "/api/destinations",
  "validationErrors": {
    "name": "Destinasyon adi bos olamaz"
  }
}
```

## CI
Bu repoda `backend-ci.yml` workflow'u:
- Java 23 kurar
- PostgreSQL service ayağa kaldırır
- `./mvnw clean verify` calistirir
