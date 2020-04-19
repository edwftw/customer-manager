FROM openjdk:8-jre
COPY build/libs/customer-manager.jar ./usr/customer-manager.jar
#EXPOSE 8080
RUN sh -c 'touch /usr/customer-manager.jar'
#ENTRYPOINT ["java","-jar","/usr/customer-manager.jar"]

ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo/local","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/customer-manager.jar"]