FROM maven:latest AS build
WORKDIR /app
COPY . /app
RUN mvn clean verify

FROM eclipse-temurin:latest
WORKDIR /app
COPY --from=build /app/target/post-reader-1.0-SNAPSHOT-jar-with-dependencies.jar post-reader-1.0-SNAPSHOT-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar", "post-reader-1.0-SNAPSHOT-jar-with-dependencies.jar"]
