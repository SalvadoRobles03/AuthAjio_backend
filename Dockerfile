FROM openjdk:17-jdk-slim

WORKDIR /app

COPY tarjet/authajio-0.0.1-SNAPSHOT app.jar

COPY /src/main/resources/env.properties env.properties

EXPOSE 8080

ENV SPRING_CONFIG_LOCATION=file:/app/env.properties


CMD ["java", "-jar", "app.jar"]

