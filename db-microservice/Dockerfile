FROM openjdk:17-jdk-slim

WORKDIR /src
COPY . /src

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew DbApplicationJar
WORKDIR /run

RUN cp /src/build/libs/DbApplication.jar /run/DbApplication.jar
CMD java -jar /run/DbApplication.jar