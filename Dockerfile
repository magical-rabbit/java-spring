FROM maven:latest as builder
WORKDIR /app
COPY ./src /app/src
COPY pom.xml /app/pom.xml
RUN mvn package

FROM openjdk:8u342-jdk-oracle
WORKDIR /opt/dayi/
COPY --from=builder /app/target/skd21_dayi_springboot.jar /opt/dayi/skd21_dayi_springboot.jar
CMD ["java", "-jar","skd21_dayi_springboot.jar"]