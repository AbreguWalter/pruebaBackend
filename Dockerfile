FROM openjdk:8-jdk-alpine

COPY ./target/spring-boot-rest-jpa-h2-example-0.0.1-SNAPSHOT.jar /opt/abregu/backend.jar

WORKDIR /opt/abregu

EXPOSE 8082

CMD ["java","-jar","-Djava.security.egd=file:/dev/./urandom","backend.jar"]