FROM openjdk:17-slim 
WORKDIR /app
COPY target/*.jar TicketApplication.jar
EXPOSE 8080
CMD ["java", "-jar", "TicketApplication.jar"]
