FROM maven:3.6.0-jdk-11-slim AS maven
WORKDIR /build
COPY pom.xml .
COPY src/ /build/src/
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=maven /build/target/product-service.jar /usr/app/product-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Djava.security.egd=file:/dev/./urandom","/usr/app/product-service.jar"]