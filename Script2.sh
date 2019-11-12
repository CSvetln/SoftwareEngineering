#! /bin/bash
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
echo Запуск без параметров Expected: 1
./run.sh
echo $?
echo Вывод справки через -h Expected: 1
./run.sh "-h"
echo $?
echo Тест -login Expected: 1
./run.sh "-login" "admin"
echo $?
echo Тест blahblah Expected: 1
./run.sh "blahblah"
echo $?
echo Обычный тест -login admin -pass admin Expected: 0
./run.sh "-login" "admin" "-pass" "admin"
echo $?
echo Граничный тест -pass admin -login admin Expected: 0
./run.sh "-pass" "admin" "-login" "admin"
echo $?
echo Ошибочные тесты
echo -login user@ -pass 123 Expected: 2
./run.sh "-login" "user@" "-pass" "123"
echo $?
echo -login user2 -pass 123 Expected: 3
./run.sh "-login" "user2" "-pass" "123"
echo $?
echo -login user1 -pass user123 Expected: 4
./run.sh "-login" "user1" "-pass" "user123"
echo $?