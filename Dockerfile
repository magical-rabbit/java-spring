FROM maven:latest as builder
WORKDIR /app
COPY ./src /app/src
COPY pom.xml /app/pom.xml
# RUN mvn package
# 国内源构建
RUN echo '<?xml version="1.0" encoding="UTF-8"?>\
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"\
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"\
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0\
                      https://maven.apache.org/xsd/settings-1.0.0.xsd">\
    <mirrors>\
        <mirror>\
            <id>aliyunmaven</id>\
            <mirrorOf>central</mirrorOf>\
            <name>Aliyun Central</name>\
            <url>https://maven.aliyun.com/repository/central</url>\
        </mirror>\
    </mirrors>\
</settings>' > /app/settings.xml && mvn -s /app/settings.xml package


FROM openjdk:8u342-jdk-oracle
WORKDIR /opt/dayi/
COPY --from=builder /app/target/skd21_dayi_springboot.jar /opt/dayi/skd21_dayi_springboot.jar
CMD ["java", "-jar","skd21_dayi_springboot.jar"]