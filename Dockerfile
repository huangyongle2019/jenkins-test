FROM jdk:8
VOLUME /tmp
ADD jenkins-test.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]