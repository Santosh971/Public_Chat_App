FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/chat-app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8005
ENTRYPOINT ["java","-jar", "app.jar"]