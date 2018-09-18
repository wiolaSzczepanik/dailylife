FROM openjdk:8-jre-alpine

ADD target/helper-0.0.1-SNAPSHOT.jar helper.jar
ENTRYPOINT ["java","-jar","/helper.jar"]

VOLUME /tmp
EXPOSE 8080