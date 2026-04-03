


# Seyahat Planlayıcı API 🌍

Seyahat destinasyonlarını yönetmek için geliştirilmiş REST API.

## Teknolojiler
- Java 23
- Spring Boot 3.5.13
- PostgreSQL
- Spring Data JPA
- Lombok

## Özellikler
- Destinasyon ekle, listele, sil
- Ülkeye göre filtrele
- Kategoriye göre filtrele
- Bütçeye göre filtrele

## API Endpoints
| Method | URL | Açıklama |
|--------|-----|----------|
| GET | /api/destinations | Tüm destinasyonlar |
| POST | /api/destinations | Yeni destinasyon ekle |
| GET | /api/destinations/{id} | ID'ye göre getir |
| DELETE | /api/destinations/{id} | Sil |
| GET | /api/destinations/country/{country} | Ülkeye göre filtrele |
| GET | /api/destinations/category/{category} | Kategoriye göre filtrele |
| GET | /api/destinations/budget/{budget} | Bütçeye göre filtrele |

## Nasıl Çalıştırılır?
1. PostgreSQL kurulu olmalı
2. `seyahat_db` veritabanı oluşturulmalı
3. `application.properties` düzenlenmeli
4. `mvn spring-boot:run` ile çalıştırılır

## API Dokümantasyonu
Swagger UI: http://localhost:8080/swagger-ui/index.html
