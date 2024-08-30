# Use an official Maven image to build the project
FROM maven:3.9.3-eclipse-temurin-18 AS build
WORKDIR /app

# Copy the pom.xml and install dependencies (caching them if unchanged)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the project and build the application
COPY src ./src
RUN mvn package -DskipTests

# Use a minimal Java runtime image to run the application
FROM eclipse-temurin:18-jdk-alpine
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/expenditure-0.0.1-SNAPSHOT.jar /app/expenditure.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "expenditure.jar"]
