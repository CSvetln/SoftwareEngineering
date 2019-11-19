#! /bin/bash
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
amountDefTests=0
amountSucTests=0

fh(){
ex=$1
echo Тест $2 $3 $4 $5
echo Expected: $ex
./run.sh $2 $3 $4 $5
res=$?
echo $res
let amountDefTests=amountDefTests+1
if [ $ex -eq $res ];
 then let amountSucTests=amountSucTests+1
fi
}

fh 1
fh 1 "-h"
fh 1 "-login" "admin"
fh 1 "blahblah"
fh 0 "-login" "admin" "-pass" "admin"
fh 0 "-pass" "admin" "-login" "admin"
fh 2 "-login" "user@" "-pass" "123"
fh 3 "-login" "user2" "-pass" "123"
fh 4 "-login" "user1" "-pass" "user123"


echo Количество тестов
echo $amountDefTests
echo Количество успешных тестов
echo $amountSucTests
if [ $amountDefTests -ne $amountSucTests ]; then
  exit 1
else
  exit 0
fi
