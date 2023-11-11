FROM openjdk:17-alpine

USER root

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

COPY build/libs/voting-app-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]