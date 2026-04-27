# 1-bosqich: Loyihani yig'ish (Build stage)
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
# Pom faylini va kodlarni nusxalash
COPY pom.xml .
COPY src ./src
# Loyihani paketlash (testlarni o'tkazib yuborish tezlik uchun)
RUN mvn clean package -DskipTests

# 2-bosqich: Ishga tushirish (Run stage)
FROM openjdk:17-jdk-slim
WORKDIR /app
# Build bosqichidan jar faylni nusxalab olish
COPY --from=build /app/target/*.jar app.jar

# Portni ochish (Spring Boot odatda 8080 da ishlaydi)
EXPOSE 8080

# Ilovani ishga tushirish buyrug'i
ENTRYPOINT ["java", "-jar", "app.jar"]