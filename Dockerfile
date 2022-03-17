FROM openjdk:17
ARG JAR_FILE=*.jar
COPY ./target/${JAR_FILE} application.jar
EXPOSE 9000:8080
ENTRYPOINT ["java", "-jar", "application.jar"]
