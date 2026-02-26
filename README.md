## Приложение заметки 
Функциональность:

* просмотр списка
* добавление 
* удаление заметки

Стек:
* Spring-Boot MVC - база
* liquibase как система миграции БД
* materialize в кач-ве шаблонизатора

### Запуск локально:
```
./gradlew :bootJar
docker buildx build -t just-notes .
docker compose up
```
Слушает 80 порт
