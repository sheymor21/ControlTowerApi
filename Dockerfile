
# Use an official OpenJDK runtime as a parent image
FROM openjdk:24-oraclelinux9
#FROM openjdk:22-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/*.jar app/app.jar

# Expose the port that the application will run on
EXPOSE 8080
# Run the jar file
ENTRYPOINT ["java", "-jar", "app/app.jar"]
LABEL authors="Sheymor"


