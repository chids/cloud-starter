FROM openjdk:8-jre-alpine
ENV JAVA_TOOL_OPTIONS -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1
ENV SCHENV=Docker

RUN mkdir -p /usr/src/app/etc
WORKDIR /usr/src/app

COPY target/001-sample.jar /usr/src/app/
COPY etc/settings.yml /usr/src/app/etc

CMD java -jar -Ddw.server.connector.type=http -Ddw.server.connector.port=$PORT 001-sample.jar server etc/settings.yml
