FROM openjdk:17-alpine
WORKDIR /flight-client-service
COPY target/flight-client-service-0.0.1-SNAPSHOT.jar .
EXPOSE 5001
CMD ["java", "-jar", "flight-client-service-0.0.1-SNAPSHOT.jar"]