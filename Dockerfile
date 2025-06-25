# Базовый образ с Java 21 (Alpine-версия для минимального размера)
FROM openjdk:21

# Открываем порт для приложения
EXPOSE 8080

# Создаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR-файл из папки target
ADD target/AuthorithationService-1.0-SNAPSHOT.jar app.jar

# Команда запуска приложения
CMD ["java", "-jar", "app.jar"]