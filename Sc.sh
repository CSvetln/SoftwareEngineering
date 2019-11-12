#! /bin/bash
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
amountDefTests=0
amountSucTests=0
ex0=0
ex5=5
ex6=6
res=0

./run.sh "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRITE"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "user1" "-pass" "user" "-res" "AB.CD.E" "-role" "EXECUTE"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.CD" "-role" "WRITE"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "admin" "-pass" "admin" "-res" "AB.CD.E" "-role" "WRITE"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "admin" "-pass" "admin" "-role" "WRITE" "-res" "AB"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "admin" "-pass" "admin" "-role" "WRITE"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-res" "AB.CD" "-role" "WRITE" "-login" "admin" "-pass" "admin"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex0 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRREAD"
res=$?
if [ $ex5 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi
let amountDefTests=amountDefTests+1

./run.sh "-login" "user1" "-pass" "user" "-res" "AB" "-role" "EXECUTE"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex6 -eq $res ]; then
  let amountSucTests=amountSucTests+1
fi

./run.sh "-login" "user1" "-pass" "user" "-res" "AB" "-role" "READ"
res=$?
let amountDefTests=amountDefTests+1
if [ $ex6 -eq $res ]; then
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





