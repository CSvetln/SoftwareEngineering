#! /bin/bash
echo "Введите параметры: "
read par
java -cp "lib/kotlinx-cli-jvm-0.2.0-SNAPSHOT.jar;app.jar" com.softwareengineering.MainKt $par
echo $?