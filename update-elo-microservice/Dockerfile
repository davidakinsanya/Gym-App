WORKDIR /src
COPY . /src

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew updateELOJar
WORKDIR /run

RUN cp /src/build/libs/updateELO.jar /run/updateELO.jar
CMD java -jar /run/updateELO.jar