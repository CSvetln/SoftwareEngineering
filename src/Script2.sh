#! /bin/bash
kotlinc Main.kt -include-runtime -d app.jar
#echo Запуск без параметров Expected: 1
#java -jar app.jar
#echo Вывод справки через -h Expected: 1
#java -jar app.jar "-h"

echo Обычный тест -login admin -pass admin Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin"
#echo Граничный тест -pass admin -login admin Expected: 0
#java -jar app.jar -pass admin -login admin
#echo Ошибочные тесты
#echo -login user@ -pass 123 Expected: 2
#java -jar app.jar -pass admin -login admin
#echo -login user2 -pass 123 Expected: 3
#java -jar app.jar -pass admin -login admin
#echo -login user1 -pass user123 Expected: 4
#java -jar app.jar -pass admin -login admin