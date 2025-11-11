# Use Maven directly instead of wrapper
FROM eclipse-temurin:25-jdk AS build

# Set the working directory
WORKDIR /app

# Copy pom.xml first (for dependency caching)
COPY pom.xml .

# Download dependencies (this step helps speed up rebuilds)
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a Java 25 runtime image to run the application
FROM eclipse-temurin:25-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8081 for the Spring Boot application
EXPOSE 8081

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

