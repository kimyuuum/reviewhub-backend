
#start with a base image containing java runtime
FROM java:8

#Author
LABEL maintainer="dbals4818@gmail.com"

VOLUME /tmp

#Make port 8080 available to the world outside this container
#EXPOSE 8080

#ARG JAR_FILE=build/libs/reviewhub-eureka-server-0.0.1-SNAPSHOT.jar
ADD build/libs/review-0.0.1-SNAPSHOT.jar reviewservice.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/reviewservice.jar"]
