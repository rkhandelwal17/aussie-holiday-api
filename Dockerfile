FROM public.ecr.aws/amazoncorretto/amazoncorretto:17.0.9-al2-native-headless
WORKDIR /app
COPY ./aussie-holiday-api/target/aussie-holiday-api-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "/app/aussie-holiday-api-1.0-SNAPSHOT.jar"]

