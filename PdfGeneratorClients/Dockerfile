# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project's jar file into the container at /app
COPY target/PdfGeneratorClients-0.0.1-SNAPSHOT.jar /app/my-spring-boot-app-client.jar

# Expose the port that the application runs on
EXPOSE 8082

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/my-spring-boot-app-client.jar"]
