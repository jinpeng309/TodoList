FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD TodoList-0.0.1-SNAPSHOT.jar app.jar
RUN touch /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"," -Dspring.profiles.active=prod","-jar","/app.jar"]