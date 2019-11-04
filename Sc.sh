#! /bin/bash
kotlinc src/com -include-runtime -d app.jar
echo Обычные

echo Тест -login admin -pass admin -res АВ.CD -role WRITE
echo Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin" "-res" "AB.CD" "-role" "WRITE"
echo $?
echo Тест -login admin -pass admin -res АВ.CD.E -role WRITE
echo Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin" "-res" "AB.CD.E" "-role" "WRITE"
echo $?
echo Тест -login admin -pass admin -res АВ.C -role READ
echo Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ"
echo $?
echo Тест -login user1 -pass user -res АВ.CD.E -role EXECUTE
echo Expected: 0
java -jar app.jar "-login" "user1" "-pass" "user" "-res" "AB.CD.E" "-role" "EXECUTE"
echo $?

echo Граничные
echo Тест -login admin -pass admin -role WRITE -res АВ
echo Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin" "-role" "WRITE" "-res" "AB"
echo $?
echo Тест -login admin -pass admin -role WRITE
echo Expected: 0
java -jar app.jar "-login" "admin" "-pass" "admin" "-role" "WRITE"
echo $?
echo Тест -res АВ.CD -role WRITE -login admin -pass admin
echo Expected: 0
java -jar app.jar "-res" "AB.CD" "-role" "WRITE" "-login" "admin" "-pass" "admin"
echo $?

echo Ошибочные
echo Тест -login admin -pass admin -res АВ -role WRREAD
echo Expected: 5
java -jar app.jar "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRREAD"
echo $?
echo Тест -login user1 -pass user -res АВ -role EXECUTE
echo Expected: 6
java -jar app.jar "-login" "user1" "-pass" "user" "-res" "AB" "-role" "EXECUTE"
echo $?
echo Тест login user1 -pass user -res АВ -role READ
echo Expected: 6
java -jar app.jar "-login" "user1" "-pass" "user" "-res" "AB" "-role" "READ"
echo $?




