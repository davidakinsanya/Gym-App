FROM mysql:latest

ENV MYSQL_ROOT_USER=root
ENV MYSQL_ROOT_PASSWORD=root

COPY . /docker-entrypoint-initdb.d/
