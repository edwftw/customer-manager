FROM openjdk:8-jre
COPY build/libs/customer-manager.jar ./usr/customer-manager.jar
RUN sh -c 'touch /usr/customer-manager.jar'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo/local","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/customer-manager.jar"]