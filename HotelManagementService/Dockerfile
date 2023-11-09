FROM openjdk:17
EXPOSE 10004
ADD target/hotel-service.jar hotel-service.jar
ENTRYPOINT [ "java","-jar","/hotel-service.jar" ]