FROM eclipse-temurin:17-jre
COPY target/*.jar qatar22.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]