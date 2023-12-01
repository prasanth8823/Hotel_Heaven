FROM openjdk:17
EXPOSE 20000
ADD target/signup-service.jar signup-service.jar
ENTRYPOINT [ "java","-jar","/signup-service.jar" ]