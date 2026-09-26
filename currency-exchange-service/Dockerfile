FROM gradle:8.5-jdk17-alpine AS build
WORKDIR /workspace
COPY settings.gradle build.gradle ./
RUN gradle --no-daemon dependencies
COPY src ./src
RUN gradle --no-daemon bootJar

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /workspace/build/libs/currency-exchange-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5003
ENTRYPOINT ["java", "-jar", "app.jar"]