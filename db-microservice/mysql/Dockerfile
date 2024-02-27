FROM mysql:latest

ENV MYSQL_ROOT_USER=root
ENV MYSQL_ROOT_PASSWORD=root

ARG user=mysqluser
ARG group=mysqluser
ARG uid=1000
ARG gid=1000

RUN groupadd -g ${gid} ${group} && useradd -u ${uid} -g ${group} -s /bin/sh ${user}
RUN chown -R ${user}:${user} /run
USER mysqluser

COPY . /docker-entrypoint-initdb.d/
