#! /bin/bash
kotlinc src/Main.kt -include-runtime -d app.jar
echo Запуск без параметров Expected: 1
java -jar app.jar
echo $?
echo Вывод справки через -h Expected: 1
java -jar app.jar "-h"
echo $?
echo Тест -login Expected: 1
java -jar app.jar "-login" "admin"
echo $?
echo Тест blahblah Expected: 1
java -jar app.jar "blahblah"
echo $?
echo Обычный тест -login admin -pass admin Expected: 0
echo Обычный тест -login admin -pass admin Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin"
echo $?
echo Граничный тест -pass admin -login admin Expected: 0
java -jar app.jar -pass admin -login admin
echo $?
echo Ошибочные тесты
echo -login user@ -pass 123 Expected: 2
java -jar app.jar -login user@ -pass 123
echo $?
echo -login user2 -pass 123 Expected: 3
java -jar app.jar  -login user2 -pass 123
echo $?
echo -login user1 -pass user123 Expected: 4
java -jar app.jar -login user1 -pass user123
echo $?