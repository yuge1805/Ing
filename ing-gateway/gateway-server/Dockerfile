#FROM jdk1.8:latest
FROM jdk1.8:v3.0
VOLUME /tmp
ADD ./target/vehicle-user.jar app.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'touch /app.jar'
RUN bash -c 'chmod 777 /wait-for-it.sh'
#CMD exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]