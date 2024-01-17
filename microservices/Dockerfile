# Starting ELO MicroService
FROM openjdk:17-jdk-slim

WORKDIR /src
COPY . /src

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew startingELOJar
WORKDIR /run

RUN cp /src/build/libs/startingELO.jar /run/startingELO.jar
CMD java -jar /run/startingELO.jar
