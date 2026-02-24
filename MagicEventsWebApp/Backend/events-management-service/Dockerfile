FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/events-management-service-0.0.1-SNAPSHOT.jar events-management-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "events-management-service.jar"]