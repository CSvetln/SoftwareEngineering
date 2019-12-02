1. Подключаем библиотеку Apache Log4j 2
2. Добавляем Logger logger в класс Enter Service  и логируем все ошибки
3. Создать файл aaa.log и настроить Log4j.properties чтобы логи сохранялись туда
4. Подключаем jar базы данных h2
5. Открываем консоль бд в браузере, создаем бд
6. Подключаем ее к проекту Connection conn = DriverManager.getConnection(...);
7. Инициализируем схему БД из файла aaa.db