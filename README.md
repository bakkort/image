# Предварительные настройки проекта

Экспорт переменных окружения для Unix ОС

```shell
export DB_USER=poem \
&& export DB_NAME=poem \
&& export DB_PASS=poem \
&& export DB_URL=jdbc:postgresql://localhost:5432/poem?currentSchema=image'
```

Экспорт переменных окружения для Windows

```shell
$env:DB_USER = 'poem'
$env:DB_NAME = 'poem'
$env:DB_PASS = 'poem'
$env:DB_URL = 'jdbc:postgresql://localhost:5432/poem?currentSchema=image'
```

> Переменные окружения видны только в той консоли, в которую были экспортированы!

# База данных

## Создание БД

Запуск docker compose

```shell
docker compose up -d
```

## Миграции
Все изменения в структуре базы оформляем через миграции, при старте приложения они автоматически
применятся.

Накатить миграции

```shell
mvn flyway:migrate
```

Пример миграции:

```
./src/main/resources/db/migration/V0_1_0__create_table_test.sql
```

Имя файла должно следовать соглашению:

* Сначала префикс `V0_1_X`, где `V0_1` это номер версии приложения, `X` номер минграции.
* Потом краткое описание, что там за изменения `create_table_test`
* Префикс отделяется от описания двойным подчеркиванием `__`

# Сборка проекта

Для очистки от файлов сборки

```
./mvnw clean
```

Для сборки

```
./mvnw package
```

Для проверки и запуска тестов

```
./mvnw verify
```
