# Developer Workout Spring Boot & Kotlin

Schau dir das Projekt an und beantworte diese Fragen:

1- Wie startet man das Projekt lokal?

- nach dem Klonen des Repos von GitHub und dem Wechsel in das Hauptverzeichnis des Backends "dev-workout-backend-kotlin"
. Voraussetzungen: JDK 17+
. Dev-Server starten (Führe den Befehl im Terminal im Verzeichnis "dev-workout-backend-kotlin" aus.): .\gradlew.bat bootRun

- Im Browser öffnen: [http://localhost:8080] oder [http://localhost:8080/products]

2- Was fehlt dem Projekt, damit es in einer Produktionsumgebung eingesetzt werden kann?

- Für Produktion würde ich ergänzen:
. Umgebungsabhängige Konfiguration (application-dev.yml, application-prod.yml)
. Logging und Monitoring (z. B. Spring Actuator: Health, Metrics)
. Einheitliche Fehlerbehandlung und Validierung
. Authentifizierung / Autorisierung (falls nötig)
. Tests (Unit- und Integrationstests)
. API-Dokumentation (Swagger / OpenAPI)
. Datenbank wie (MySQL, PostgreSQL, MongoDB, ...) statt In-Memory-Daten
. Containerisierung (Docker) und CI-Pipeline

3- Wie kannst du die Endpoints im ProductController ausprobieren?

- Man kann die Endpoints testen mit:
. Browser: [http://localhost:8080/products]
. curl: ```curl http://localhost:8080/products```
. Tools: Postman oder Insomnia

4- Sind die Endpoints im CartController gut definiert? Wenn nein, wie würdest du sie verbessern? Warum?

- Die Endpoints funktionieren, sind aber nicht optimal REST-konform.

## Aktuell

GET /cart/items
POST /cart/addItem
POST /cart/removeItemFromCart

## Verbesserungsvorschlag

GET /cart → Warenkorb anzeigen
POST /cart/items → Produkt hinzufügen
PATCH /cart/items/{productId} → Menge ändern
DELETE /cart/items/{productId} → Produkt entfernen
DELETE /cart → Warenkorb leeren

- Warum:
. Klarere URLs
. Richtige HTTP-Methoden
. Einfachere Nutzung im Frontend
. Bessere Erweiterbarkeit
Außerdem sollte klar definiert sein, wie die id übergeben wird (@PathVariable oder @RequestParam).

5- Fällt dir eine Fachlichkeit eines typischen Warenkorbs ein, die im CartController fehlt?

- Es fehlen einige typische Funktionen:
. Mengenverwaltung (gleiche Produkte zusammenfassen)
. Warenkorb leeren
. Rückgabe des aktualisierten Warenkorbs nach Änderungen
. Validierung (Produkt existiert, Menge > 0)
. Gesamtsumme / Zwischensumme
. Funktionalität: Lagerbestandsprüfung

6- Welche Verbesserungen würdest du am Code vornehmen?

- Ich würde zum Beispiel:
. Product als data class schreiben (idiomatischer in Kotlin)
. Im Warenkorb eine Struktur mit quantity verwenden statt `MutableList<Product>`
. DTOs für Requests nutzen (z. B. AddToCartRequest)
. Backend-Ordner klarer strukturieren.
. Klare Rückgaben aus Controller-Methoden verwenden
. Validierung ergänzen
. Tests hinzufügen
. CORS konfigurationsabhängig machen (Dev erlaubt localhost, Prod restriktiver)
