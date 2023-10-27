FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar projektzespolowy-1.0-TRANSITION-2.jar
ENTRYPOINT ["java","-jar","/app.jar"]