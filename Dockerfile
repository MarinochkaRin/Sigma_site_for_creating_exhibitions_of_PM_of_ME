#FROM eclipse-temurin:18
#VOLUME /tmp
#WORKDIR /app
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/Cinema.jar"]
#VOLUME /tmp
#COPY ./out/artifacts/Cinema_jar/Cinema.jar /app/Cinema.jar
#ENTRYPOINT ["java","-jar","/app/exhibitions.jar"]
# Указываем рабочую папку
#
# Копируем все файлы проекта в контейнер
#COPY . /var/www/html

#COPY ROOT.war /usr/local/tomcat/webapps/
# Используем образ с установленной Java 17
FROM adoptopenjdk:20-jdk-hotspot

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копируем скомпилированный JAR файл приложения в контейнер
COPY ./out/artifacts/exhibitions_jar/exhibitions.jar ./app/exhibitions.jar

# Запуск приложения при старте контейнера
CMD ["java", "-jar", "/app/exhibitions.jar"]