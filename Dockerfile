FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
# copy WAR into image
COPY  target/employee-0.0.1-SNAPSHOT.jar /employee.jar

EXPOSE 8080

# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "employee.jar"]
