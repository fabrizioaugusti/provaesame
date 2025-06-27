FROM eclipse-temurin:21-jdk-jammy

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

EXPOSE 3050

ENTRYPOINT ["java","-jar","/app.jar"]

##docker build -t post .

##docker run -p 3050:8080 post
