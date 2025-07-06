Cloud Touch: Web Service Based Flight Booking App
Abstract
This web service application project was designed and developed to serve flight booking. The purpose is to design an interactive and seamless user experience while flight booking. The application is developed using JSP with MySQL Workbench for data storage. Multiple services are integrated such as user authentication, Google Maps API for distance calculation, and a currency exchange API for currency conversion. Data is exchanged in JSON format for ease of manipulation. This application addresses most assignment guideline features.

Keywords: MySQL, API, Flight Booking, Web Services

1. Service Oriented Architecture
Figure 1. Service Oriented Architecture for the application

pgsql
Copy
Edit
+-------------------+          +-------------------+          +--------------------+
|   Client Service   | <------> |   Core Services   | <------> | Currency Conversion |
| (JSP + REST APIs)  |          | (Flight Booking)  |          |       Service       |
+-------------------+          +-------------------+          +--------------------+
           |                              |
           |                              |
           v                              v
     +-------------------+          +-------------------+
     |  Google Maps API   |          |   MySQL Database  |
     +-------------------+          +-------------------+
Core services communicate through a specified port.

APIs handle client requests and responses.

MySQL Workbench manages data storage.

JMeter is used to simulate load balancing and performance testing by generating concurrent client requests.

The UI uses JSP technology integrating Java into HTML pages for interactive experience.

2. Development Stack
Component	Technology/Tool
Programming Language	Java (JSP for frontend)
Backend Framework	Spring Boot
IDE/Platform	Visual Studio
Database	MySQL Workbench
Testing Tool	Apache JMeter
APIs	Google Maps, Currency Conversion

Figure 2. Workflow diagram for the application

pgsql
Copy
Edit
[User Request] --> [Client Service (JSP + REST API)] --> [Core Service]
                                                   |
                                                   v
                                 [Google Maps API] & [Currency Conversion API]
                                                   |
                                                   v
                                            [MySQL Database]
                                                   |
                                                   v
                                          [Response to Client]
3. Application Design & Features
Functional Description
RESTful APIs: Three services - Client Web Service, Core Flight Service, Currency Conversion Service.

Flight Reservation: Search flights by origin, destination, and date.

Booking: Book flights and update seat availability.

Currency Conversion: Auto-convert ticket prices to preferred currency.

Performance Analysis: Evaluated using JMeter.

Data Storage: MySQL stores user and booking details; flight data stored as JSON.

Modular Architecture: Promotes scalability and maintainability.

Validation: Input and data integrity validation.

Design Decisions
Integrated external currency conversion service.

Robust error handling for currency API failures.

Asynchronous processing for lower latency.

4. Quality of Service (QoS) Challenges
Scalability is essential as user base grows.

Challenges: resource efficiency, response times, availability during peaks.

Solutions: load balancing, horizontal scaling, performance optimization.

Requires proactive monitoring and capacity planning.

5. QoS Testing and Performance Analysis
Simulated load with JMeter for profiling, stress, and load testing.

Key metrics: error rates, throughput, response times.

Testing helps identify bottlenecks and optimize performance.

Regular testing recommended for continuous optimization.

Figure 3. Sample JMeter Test Report (conceptual)

bash
Copy
Edit
+---------------------+---------+---------+----------+
| API Endpoint        | Avg Time | Errors  | Throughput|
+---------------------+---------+---------+----------+
| /searchFlights      | 250 ms  | 0       | 150 req/s |
| /bookFlight         | 300 ms  | 2       | 120 req/s |
| /convertCurrency    | 150 ms  | 0       | 180 req/s |
+---------------------+---------+---------+----------+
6. Utilizing Cloud Computing for Scalability
Cloud providers (AWS, Azure, GCP) offer auto-scaling.

Dynamically adjust resources based on CPU/network load.

Benefits: pay-as-you-go, global availability, managed tools.

Challenges: deployment type selection, integration, security, vendor lock-in.

7. Challenges Associated with Cloud Migration
Deployment choice: public, private, hybrid, multi-cloud.

Careful migration planning required to minimize disruption.

Risks: vendor lock-in, security, data migration, integration.

Importance of risk assessment and mitigation.

8. Application of Semantic Web and Linked Data Technologies
Linked Open Data (LOD) enables richer travel service features.

Use public datasets for geography, culture, tourism, events.

Themed vacation suggestions using LOD, sentiment analysis, user reviews.

Geographic data enhances personalized, location-based recommendations.

Technologies used: RDF, OWL, SPARQL for data integration and querying.

