FROM maven:3.6.3-openjdk-11-slim
ADD ./ /source
WORKDIR /source
RUN [ "mvn", "package" ]
RUN [ "mv", "/source/target/customerreviewserver-0.0.1-SNAPSHOT.jar", "/app.jar" ]
ENTRYPOINT [ "java", "-jar", "/app.jar" ]
EXPOSE 8080