# Developer Workout Spring Boot & Kotlin

Schau dir das Projekt an und beantworte diese Fragen:

## 1) Wie startet man das Projekt lokal?

- Repo klonen und ins Verzeichnis gehen:
  - `cd dev-workout-backend-kotlin`

Voraussetzung: JDK 17+

Starten:
`./gradlew.bat bootRun`

Backend läuft dann hier: [http://localhost:8080] => [http://localhost:8080/products]

## 2) Was fehlt dem Projekt, damit es in einer Produktionsumgebung eingesetzt werden kann?

Für Produktion würde ich ergänzen:

- Umgebungsabhängige Konfiguration (z. B. application-dev.yml / application-prod.yml)
- Logging + Monitoring (Spring Actuator: Health, Metrics)
- Validierung + einheitliche Fehlerbehandlung
- Authentifizierung / Autorisierung (falls nötig)
- Tests (Unit + Integration)
- API-Dokumentation (Swagger / OpenAPI)
- richtige Datenbank statt In-Memory Liste
- CI/CD (Build, Tests, Deploy)
- CORS in Prod restriktiver (nur erlaubte Domains)

## 3) Wie kannst du die Endpoints im ProductController ausprobieren?

- Browser: [http://localhost:8080/products]

- curl:
  - `curl http://localhost:8080/products`

- Tools:
  - Postman / Insomnia

## 4) Sind die Endpoints im CartController gut definiert? Wenn nein, wie würdest du sie verbessern? Warum?

Die Endpoints funktionieren, aber sind nicht optimal REST-konform.

Aktuell:

- `GET /cart/items`
- `POST /cart/addItem`
- `POST /cart/removeItemFromCart`

Verbesserung (REST):

- `GET /cart` → Warenkorb anzeigen
- `POST /cart/items` → Produkt hinzufügen
- `PATCH /cart/items/{productId}` → Menge ändern
- `DELETE /cart/items/{productId}` → Produkt entfernen
- `DELETE /cart` → Warenkorb leeren

Warum:

- klarere URLs
- passende HTTP-Methoden
- einfacher im Frontend zu benutzen
- besser erweiterbar

## 5) Fällt dir eine Fachlichkeit eines typischen Warenkorbs ein, die im CartController fehlt?

Typische Punkte, die fehlen:

- Mengenverwaltung (quantity pro Produkt)
- Warenkorb leeren
- Rückgabe des aktualisierten Warenkorbs nach add/remove
- Validierung (Produkt existiert? Menge > 0?)
- Zwischensumme / Gesamtsumme
- ggf. Lagerbestand-Prüfung

## 6) Welche Verbesserungen würdest du am Code vornehmen?

- Package/Ordnerstruktur klarer machen (config/controller/model/data)
- `Product` als `data class` (idiomatischer Kotlin)
- Cart als `Map<ProductId, quantity>` statt `MutableList<Product>`
- DTOs für Requests nutzen (z. B. AddToCartRequest mit productId + quantity)
- Controller sollten Response zurückgeben (z. B. aktualisierten Cart)
- Tests ergänzen
- CORS:
  - Dev: localhost erlauben
  - Prod: nur die Frontend-Domain erlauben

## Hosting

Backend ist deployed auf Render: [https://dev-workout-backend-kotlin.onrender.com/products]
