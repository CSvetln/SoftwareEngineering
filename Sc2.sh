#! /bin/bash
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
amountDefTests=0
amountSucTests=0
ex0=0
ex7=7
res=0

echo Обычный
echo Тест -login admin -pass admin -res АВ -role WRITE -ds 2015-12-01 -de 2015-12-02 -vol 15
echo Expected: 0
./run.sh "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRITE" "-ds" "2015-12-01" "-de" "2015-12-02" "-vol" "15"
res=$?
echo res
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

echo Граничный
echo Тест -login admin -pass admin -res АВ.C -role READ -ds 2015-12-02 -de 2015-12-01 -vol 15
echo Expected: 0
./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015-12-02" "-de" "2015-12-01" "-vol" "15"
res=$?
echo res
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

echo Ошибочные
echo Тест -login admin -pass admin -res АВ.C -role READ -ds 2015 -de 2015 -vol 15
echo Expected: 7
./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015" "-de" "2015" "-vol" "15"
res=$?
echo res
let amountDefTests=amountDefTests+1
if [ $ex7 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi
echo Тест -login admin -pass admin -res АВ.C -role READ -ds 2015-12-02 -de 2015-12-01 -vol 15
echo Expected: 7
./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015-12-02" "-de" "2015-12-01" "-vol" "0,2"
res=$?
echo res
let amountDefTests=amountDefTests+1
if [ $ex7 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi
echo Тест -login admin -pass admin -res АВ.C -role READ -ds 2015-12-02 -de 2015-12-01 -vol 15
echo Expected: 7
./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015-12-02" "-de" "2015-12-01" "-vol" "many"
res=$?
echo res
let amountDefTests=amountDefTests+1
if [ $ex7 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

echo Количество тестов
echo $amountDefTests
echo Количество успешных тестов
echo $amountSucTests
if [ $amountDefTests -ne $amountSucTests ]; then
  echo ExitProcess 1
else
  echo ExitProcess 0
fi