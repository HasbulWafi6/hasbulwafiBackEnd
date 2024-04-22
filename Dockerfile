FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-crud-data-jpa-h2db-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/spring-boot-crud-data-jpa-h2db-0.0.1-SNAPSHOT.jar"]
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar springbootcrudjpah2master.jar
