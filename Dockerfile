FROM alpine:3.10
RUN apk update
RUN apk add openjdk11
VOLUME /tmp
ARG DEPENDENCY=build/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8081
ENTRYPOINT ["java","-cp","app:app/lib/*","com.sti.ssm.StiSsmApplication"]
