## Приложение заметки 

### Запуск локально:
```
./gradlew :bootJar
docker buildx build -t just-notes .
docker compose up
```
Слушает 80 порт
