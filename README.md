Запуск локально:
```
./gradlew :bootJar
docker buildx build -t just-notes .
docker compose up
```
Слушает 80 порт локально
### Приложение заметки ### 
Посмотреть можно тут http://45.82.152.61:8080/
