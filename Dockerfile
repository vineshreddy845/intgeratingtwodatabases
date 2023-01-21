FROM openjdk:11
ADD target/springboot-integeration.jar springdocker.jar
ENTRYPOINT ["java","-jar","/springdocker.jar"]