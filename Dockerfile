FROM gradle:8.7-jdk17

WORKDIR /Java-SMS-Quickstart

# Copy the source code into the container
COPY . .

# Build the application using gradle
RUN gradle build

# Run the application
CMD ["java", "-Dserver.port=3000", "-jar", "build/libs/Java-SMS-Quickstart-plain.jar"]
