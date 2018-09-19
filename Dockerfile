# A basic openjdk
FROM openjdk:8
ADD target/tantalum-docker.jar tantalum-docker.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "tantalum-docker.jar"]
