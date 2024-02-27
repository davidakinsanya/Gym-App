FROM openjdk:17-jdk-slim

WORKDIR /src
COPY . /src

ARG user=javauser
ARG group=javauser
ARG uid=1000
ARG gid=1000

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew clean build jar
WORKDIR /run

RUN groupadd -g ${gid} ${group} && useradd -u ${uid} -g ${group} -s /bin/sh ${user}
RUN chown -R ${user}:${user} /run
USER javauser

RUN cp /src/build/libs/db-microservice-0.0.1-SNAPSHOT.jar /run/DbApplication.jar
CMD java -jar /run/DbApplication.jar