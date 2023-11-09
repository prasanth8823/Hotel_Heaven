FROM openjdk:17
EXPOSE 10000
ADD target/signup-service.jar signup-service.jar
ENTRYPOINT [ "java","-jar","/signup-service.jar" ]