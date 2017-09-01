FROM openjdk:8
RUN mkdir -p /usr/src/app/etc
COPY etc/settings.yml /usr/src/app/etc
COPY target/001-sample.jar /usr/src/app
WORKDIR /usr/src/app
ENV SCHENV=Docker
CMD java -jar -Ddw.server.connector.type=http -Ddw.server.connector.port=$PORT 001-sample.jar server etc/settings.yml
