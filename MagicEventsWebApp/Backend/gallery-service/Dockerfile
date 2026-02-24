FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/gallery-service-0.0.1-SNAPSHOT.jar gallery-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "gallery-service.jar"]