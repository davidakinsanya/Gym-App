FROM openjdk:17-jdk-slim

WORKDIR /src
COPY . /src

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew clean build jar
WORKDIR /run

RUN cp /src/build/libs/starting-elo-microservice-0.0.1-SNAPSHOT.jar /run/startingELO.jar
CMD java -jar /run/startingELO.jar
