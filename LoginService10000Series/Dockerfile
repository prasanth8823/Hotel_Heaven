FROM openjdk:17
EXPOSE 10001
ADD target/login-service.jar login-service.jar
ENTRYPOINT [ "java","-jar","/login-service.jar" ]