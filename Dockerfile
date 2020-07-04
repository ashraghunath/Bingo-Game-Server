FROM openjdk:8
ADD target/bingo-0.0.1-SNAPSHOT.jar bingo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bingo-0.0.1-SNAPSHOT.jar"]