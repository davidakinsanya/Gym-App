FROM openjdk:17-jdk-slim

WORKDIR /src
COPY . /src

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew jar
WORKDIR /run

RUN cp /src/build/libs/*.jar /run/startingELO.jar
CMD java -jar /run/startingELO.jar
