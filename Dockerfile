# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper & project files
COPY . .

# Build the application using the wrapper
RUN ./mvnw clean package -DskipTests

# Run the jar file (replace with your actual jar name if needed)
CMD ["java", "-jar", "target/carapi-0.0.1-SNAPSHOT.jar"]
