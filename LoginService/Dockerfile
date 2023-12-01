FROM openjdk:17
EXPOSE 20001
ADD target/login-service.jar login-service.jar
ENTRYPOINT [ "java","-jar","/login-service.jar" ]