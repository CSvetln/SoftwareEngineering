#! /bin/bash
kotlinc -cp lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
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
fh 0
fh 0 "-h"
fh 1 -login 'XXX' -pass 'XXX'
fh 2 -login 'jdoe' -pass 'XXX'
fh 0 -login 'jdoe' -pass 'sup3rpaZZ'
fh 0 -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a'
fh 0 -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b'
fh 3 -login 'jdoe' -pass 'sup3rpaZZ' -role 'XXX' -res 'a.b'
fh 4 -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'XXX'
fh 4 -login 'jdoe' -pass 'sup3rpaZZ' -role 'WRITE' -res 'a'
fh 4 -login 'jdoe' -pass 'sup3rpaZZ' -role 'WRITE' -res 'a.bc'
fh 0 -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol '100'
fh 5 -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b' -ds '01-01-2015' -de '2015-12-31' -vol '100'
fh 5 -login 'jdoe' -pass 'sup3rpaZZ' -role 'READ' -res 'a.b' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
fh 1 -login 'X' -pass 'X' -role 'READ' -res 'X' -ds '2015-01-01' -de '2015-12-31' -vol 'XXX'
fh 1 -login 'X' -pass 'X' -role 'READ' -res 'X'

echo Количество тестов
echo $amountDefTests
echo Количество успешных тестов
echo $amountSucTests
if [ $amountDefTests -ne $amountSucTests ]; then
  echo ExitProcess 1
else
  echo ExitProcess 0
fi