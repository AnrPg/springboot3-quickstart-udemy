FROM maven:3.9.6-eclipse-temurin-21-alpine

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# RUN mvn dependency:tree
RUN mvn clean package -DskipTests

COPY src ./src
# RUN chmod a+x .
# VOLUME . .

CMD ["./mvnw", "spring-boot:run"]