#! /bin/bash
kotlinc -cp kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
amountDefTests=0
amountSucTests=0
res=0

fh(){
ex=$1
echo Тест $2 $3 $4 $5 $6 $7 $8 $9 ${10} ${11} ${12} ${13} ${14} ${15}
echo Expected: $ex
./run.sh $2 $3 $4 $5 $6 $7 $8 $9 ${10} ${11} ${12} ${13} ${14} ${15}
res=$?
echo $res
let amountDefTests=amountDefTests+1
if [ $ex -eq $res ];
 then let amountSucTests=amountSucTests+1
fi
}


fh 0 "-login" "admin" "-pass" "admin" "-res" "AB" "-role" "WRITE" "-ds" "2015-12-01" "-de" "2015-12-02" "-vol" "15"

fh 0 "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015-12-02" "-de" "2015-12-01" "-vol" "15"

fh 7 "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015" "-de" "2015" "-vol" "15"

fh 7 "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015-12-02" "-de" "2015-12-01" "-vol" "0,2"

fh 7 "-login" "admin" "-pass" "admin" "-res" "AB.C" "-role" "READ" "-ds" "2015-12-02" "-de" "2015-12-01" "-vol" "many"


echo Количество тестов
echo $amountDefTests
echo Количество успешных тестов
echo $amountSucTests
if [ $amountDefTests -ne $amountSucTests ]; then
  echo ExitProcess 1
else
  echo ExitProcess 0
fi