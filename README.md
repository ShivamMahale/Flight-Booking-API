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

## First-Time Setup and Run (Windows)

### Prerequisites

1. Install a Java 17 JDK and MySQL Server. Git is needed to clone the repository.
2. Make sure MySQL Server is running. Open PowerShell and confirm Java is available with `java -version`; it should report version 17.
3. Clone the repository and open its root folder in VS Code:

```powershell
git clone https://github.com/ShivamMahale/Flight-Booking-API.git
cd .\Flight-Booking-API
code .
```

You do not need to install Gradle or Maven separately. The Gradle and Maven wrapper scripts in the services download their required build tools and dependencies the first time they run, so the first startup needs internet access.

### Prepare MySQL

The core service defaults to `jdbc:mysql://localhost:3306/cloud_touch` and database user `root`. Create its database once. In PowerShell, connect using your MySQL root password:

```powershell
mysql -u root -p
```

At the MySQL prompt, run:

```sql
CREATE DATABASE cloud_touch;
exit
```

The core service prompts for the MySQL password when started from the VS Code task below. For a non-root MySQL account or a different database address, set `DB_USERNAME` or `DB_URL` in the environment inherited by VS Code before launching it.

### Start from VS Code

Ensure MySQL is running, then in VS Code select **Terminal > Run Task > Flight: Start All Services**. The task securely prompts for the MySQL password and launches the core, currency exchange, and web client in separate terminals. They start in parallel.

Open <http://localhost:5005> when the services have started. The core service listens on port `5004`; currency exchange listens on `5003`. Currency conversion fetches rates from Frankfurter and requires internet access, but no API key. The Google Maps directions feature is optional; set `GOOGLE_MAPS_API_KEY` in the environment before starting VS Code if you need it.

### Start Manually

Alternatively, open three PowerShell terminals at the repository root. Set the MySQL password in the core terminal, then run each service in its own terminal:

```powershell
# Terminal 1: flight core
$secure = Read-Host "MySQL password" -AsSecureString
$env:DB_PASSWORD = [System.Net.NetworkCredential]::new("", $secure).Password
cd .\flight-core-service
.\gradlew.bat bootRun
```

```powershell
# Terminal 2: currency exchange
cd .\currency-exchange-service
.\gradlew.bat bootRun
```

```powershell
# Terminal 3: web client
cd .\flight-client-service
.\mvnw.cmd spring-boot:run
```

The client is at <http://localhost:5005>. Its default service URLs are `http://localhost:5004/flight-service` and `http://localhost:5003`. For other environments, configure `FLIGHT_CORE_BASE_URL`, `CURRENCY_EXCHANGE_BASE_URL`, and the service port variables. Set `JPA_DDL_AUTO=validate` for a production schema; local development uses `update`.

### Stop the Services

Press `Ctrl+C` in each service terminal and wait for Spring Boot to stop. MySQL can remain running; stop it separately through Windows Services if you no longer need it.

### Credential Hygiene

The Google Maps key and database password were previously committed in configuration. Revoke or rotate any real credentials that were used, restrict replacement API keys to the required APIs and allowed application origins, and never commit credentials or `.env` files. Removing a secret from the current files does not remove it from existing Git history; if this repository was shared, treat exposed credentials as compromised.

