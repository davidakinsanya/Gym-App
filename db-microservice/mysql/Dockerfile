FROM mysql:latest

ENV MYSQL_ROOT_USER=root
ENV MYSQL_ROOT_PASSWORD=root

RUN addgroup --system mysqluser && adduser -S -s /bin/false -G mysqluser mysqluser
RUN chown -R mysqluser:mysqluser /app
USER mysqluser

COPY . /docker-entrypoint-initdb.d/
