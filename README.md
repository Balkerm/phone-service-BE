# phone-service-BE
spring boot application that serve phone numbers from sqlite db through REST controller

# Prerequisites
Java JDK version 11
gradle 7.3.3

# To Run:
cd phone-service-BE
gradle build
java -jar build/libs/phone-service-BE-0.0.1.jar

# To Create a docker image, then run in container
cd phone-service-BE
gradle build
docker build --build-arg JAR_FILE=build/libs/phone-service-BE-0.0.1.jar -t <image-name> .
docker run -p 8080:8080 <image-name>
