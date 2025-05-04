# Use a mesma versão do Gradle que está no gradle-wrapper.properties
FROM gradle:8.4-jdk17 AS builder

WORKDIR /app
COPY . .

# Configura o cache do Gradle em um local com permissões adequadas
ENV GRADLE_USER_HOME=/app/.gradle
RUN gradle clean buildFatJar --no-daemon --stacktrace

FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]