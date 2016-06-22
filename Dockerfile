FROM registry.opensource.zalan.do/stups/openjdk:8-27

EXPOSE 8085

COPY target/zmon-scheduler-1.0-SNAPSHOT.jar /zmon-scheduler.jar
COPY target/scm-source.json /

CMD java $JAVA_OPTS $(java-dynamic-memory-opts) -jar zmon-scheduler.jar
