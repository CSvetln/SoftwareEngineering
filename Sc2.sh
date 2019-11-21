#! /bin/bash
kotlinc -cp lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
amountDefTests=0
amountSucTests=0
res=0

fh(){
ex=$1
echo Тест $2 $3 $4 $5 $6 $7 $8 $9
echo Expected: $ex
./run.sh $2 $3 $4 $5 $6 $7 $8 $9
res=$?
echo $res
let amountDefTests=amountDefTests+1
if [ $ex -eq $res ];
 then let amountSucTests=amountSucTests+1
fi
}


fh 0 "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRITE"
fh 0 "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ"
fh 0 "-login" "user1" "-pass" "user" "-res" "AB.CD.E" "-role" "EXECUTE"
fh 0 "-login" "admin" "-pass" "admin" "-res" "AB.CD" "-role" "WRITE"
fh 0 "-login" "admin" "-pass" "admin" "-res" "AB.CD.E" "-role" "WRITE"
fh 0 "-login" "admin" "-pass" "admin" "-role" "WRITE" "-res" "AB"
fh 0 "-login" "admin" "-pass" "admin" "-role" "WRITE"
fh 0 "-res" "AB.CD" "-role" "WRITE" "-login" "admin" "-pass" "admin"
fh 5 "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRREAD"
fh 6 "-login" "user1" "-pass" "user" "-res" "AB" "-role" "EXECUTE"
fh 6 "-login" "user1" "-pass" "user" "-res" "AB" "-role" "READ"


echo Количество тестов
echo $amountDefTests
echo Количество успешных тестов
echo $amountSucTests
if [ $amountDefTests -ne $amountSucTests ]; then
  echo ExitProcess 1
else
  echo ExitProcess 0
fi





