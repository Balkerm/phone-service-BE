FROM openjdk:11
ARG JAR_FILE=build/libs/phone-service-BE-0.0.1.jar
COPY ${JAR_FILE} phone-service-BE.jar
COPY sample.db sample.db
COPY test.db test.db
ENTRYPOINT ["java","-jar","/phone-service-BE.jar"]