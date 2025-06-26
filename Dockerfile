FROM eclipse-temurin:21-jdk-jammy

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

##docker build -t post .

##docker run -p 8080:8080 post
