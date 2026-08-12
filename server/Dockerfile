FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY server/target/aicoding-server-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
