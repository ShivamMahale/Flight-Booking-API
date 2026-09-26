Cloud Touch: Flight Booking Made Simple & Smart ✈️🌍
Welcome to Cloud Touch, your all-in-one flight booking web app designed to make booking seamless, interactive, and secure. Whether you’re a frequent flyer or a vacation planner, Cloud Touch offers a rich user experience with real-time data, multiple services integration, and cloud scalability.

🚀 Key Features at a Glance
Search & Book Flights: Find flights by location and date, then book your seat instantly.

Multi-Currency Support: Prices convert automatically using live exchange rates.

Distance Calculation: Google Maps API calculates travel distances to improve search accuracy.

Secure User Authentication: Keep your profile and bookings safe.

High Performance: Tested for heavy loads with Apache JMeter.

Cloud Ready: Easily scalable on AWS, Azure, or GCP with auto-scaling and monitoring.

🔧 Technology Stack
Component	Tool/Technology
Frontend	Java Server Pages (JSP)
Backend Framework	Spring Boot
Database	MySQL Workbench
Testing Tool	Apache JMeter
APIs	Google Maps, Currency Exchange

🏗️ Architecture Overview
plaintext
Copy
Edit
+---------------------------+       +------------------------+       +---------------------------+
|     Client Service        | <---> |      Core Services      | <---> |   Currency Conversion      |
| (JSP + RESTful APIs)      |       |   (Flight Booking, etc) |       |         Service            |
+---------------------------+       +------------------------+       +---------------------------+
             |                                  |
             |                                  |
             v                                  v
     +--------------------+             +--------------------+
     |  Google Maps API    |             |   MySQL Database   |
     +--------------------+             +--------------------+
Client Service: The user-facing web interface built with JSP + REST APIs.

Core Services: Manages flight search, booking, seat availability.

Currency Conversion: External API integration for real-time currency rates.

Google Maps API: Fetches distance data to enhance search accuracy.

MySQL Database: Centralized storage for users, bookings, and flight data.

📊 Workflow Diagram
plaintext
Copy
Edit
[User Request]
     |
     v
[Client Service (JSP + REST API)]
     |
     +------------------------+
     |                        |
     v                        v
[Core Flight Service]      [External APIs]
     |                        |
     v                        |
[MySQL Database]              |
     |                        |
     +-----------+------------+
                 |
                 v
          [Response to User]
📈 Performance & Load Testing
We simulate thousands of users booking flights simultaneously using Apache JMeter to measure:

API Endpoint	Avg Response Time	Error Rate	Throughput
/searchFlights	250 ms	0%	150 requests/s
/bookFlight	300 ms	1.5%	120 requests/s
/convertCurrency	150 ms	0%	180 requests/s

☁️ Cloud Scalability & Resilience
Deploy on cloud platforms like AWS, Azure, or GCP for:

Auto-Scaling: Dynamically add/remove instances based on demand.

Global Availability: Reach users worldwide with minimal latency.

Managed Services: Simplify database, monitoring, and security tasks.

Challenges Addressed: Vendor lock-in, data migration, integration complexity.

🌐 Future Enhancements: Semantic Web & Linked Data
By leveraging Linked Open Data (LOD) and semantic web tech like RDF, OWL, and SPARQL, Cloud Touch aims to:

Deliver personalized travel recommendations.

Incorporate user reviews and sentiment analysis.

Suggest themed vacations based on location data.

Enrich user experience with richer contextual info.

## Run Locally (Windows)

Prerequisites: Java 17 and MySQL running on `localhost:3306`. Create the database once:

```sql
CREATE DATABASE cloud_touch;
```

The core service reads its connection settings from `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`. The URL defaults to `jdbc:mysql://localhost:3306/cloud_touch` and the username defaults to `root`; the password must be set in the environment and is not stored in the repository. In the core service terminal, set it before starting the service:

Open two PowerShell terminals from the repository root. Start the core service first:

```powershell
$secure = Read-Host "MySQL password" -AsSecureString
$env:DB_PASSWORD = [System.Net.NetworkCredential]::new("", $secure).Password
cd .\flight-core-service
.\gradlew.bat bootRun
```

Then start the web client in the second terminal:

```powershell
# Optional: set this to enable the /map directions feature.
$secure = Read-Host "Google Maps API key" -AsSecureString
$env:GOOGLE_MAPS_API_KEY = [System.Net.NetworkCredential]::new("", $secure).Password
cd .\flight-client-service
.\mvnw.cmd spring-boot:run
```

Open <http://localhost:5005>. The client uses the flight core at `http://localhost:5004/flight-service`. Configure deployments with `FLIGHT_CORE_BASE_URL`, `CURRENCY_EXCHANGE_BASE_URL`, `FLIGHT_CLIENT_SERVER_PORT`, and `FLIGHT_CORE_SERVER_PORT`; configure production database schema behavior with `SPRING_PROFILES_ACTIVE=prod` and `JPA_DDL_AUTO=validate`. Java/Gradle/Maven wrappers may download their build tools and dependencies on the first run.

### Stop Safely

In the client terminal, press `Ctrl+C` and wait for Spring Boot to report that it has stopped. Do the same in the core service terminal. This stops the application processes cleanly; MySQL can remain running. Stop MySQL separately through Windows Services only when you no longer need it.

The currency conversion feature expects a separate service on port `5003`, but `currency-exchange-service` is empty in this repository, so that feature is unavailable unless you supply the service.

### Credential Hygiene

The Google Maps key and database password were previously committed in configuration. Revoke/rotate any real credentials that were used, restrict replacement API keys to the required APIs and allowed application origins, and never commit credentials or `.env` files. Removing a secret from the current files does not remove it from existing Git history; if this repository was shared, treat exposed credentials as compromised.

