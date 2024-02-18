FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root

COPY ./database-uplift.sql /docker-entrypoint-initdb.d/
