#! /bin/bash
kotlinc -cp lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar src/com -include-runtime -d app.jar
amountDefTests=0
amountSucTests=0
res=0

fh(){
ex=$1
echo Тест $2
echo Expected: $ex
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar;app.jar" com.softwareengineering.MainKt $2
res=$?
echo $res
let amountDefTests=amountDefTests+1
if [ $ex -eq $res ];
 then let amountSucTests=amountSucTests+1
fi
}
fh 0
fh 0 "-h"
fh 2 "-login X-X -pass XXX"
fh 3 "-login XXX -pass XXX"
fh 4 "-login jdoe -pass XXX"
fh 0 "-login jdoe -pass sup3rpaZZ"
fh 0 "-login jdoe -pass sup3rpaZZ -role READ -res a"
fh 0 "-login jdoe -pass sup3rpaZZ -role READ -res a.b"
fh 5 "-login jdoe -pass sup3rpaZZ -role XXX -res a.b"
fh 6 "-login jdoe -pass sup3rpaZZ -role READ -res XXX"
fh 6 "-login jdoe -pass sup3rpaZZ -role WRITE -res a"
fh 6 "-login jdoe -pass sup3rpaZZ -role WRITE -res a.bc"
fh 0 "-login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100"
fh 7 "-login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100"
fh 7 "-login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX"
fh 3 "-login X -pass X -role READ -res X -ds 2015-01-01 -de 2015-12-31 -vol XXX"
fh 3 "-login X -pass X -role READ -res X"

echo Количество тестов
echo $amountDefTests
echo Количество успешных тестов
echo $amountSucTests
if [ $amountDefTests -ne $amountSucTests ]; then
  exit 1
else
  exit 0
fi