# Use an official Maven image to build the project
FROM maven:3.9.3-eclipse-temurin-18 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:18-jdk-alpine
COPY --from=build /app/target/expenditure-0.0.1-SNAPSHOT.jar /app/expenditure.jar

EXPOSE 8088
ENTRYPOINT ["java", "-jar", "expenditure.jar"]
