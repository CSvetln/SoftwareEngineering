1. Подключаем библиотеку Apache Log4j 2 +
2. Добавляем Logger logger в класс Enter Service  и логируем все ошибки + 
3. Создать файл aaa.log и настроить Log4j.properties чтобы логи сохранялись туда
4. Подключаем jar базы данных h2 +
5. Подключаем jar flyway +
6. Интегрируем flyway -  Flyway flyway = Flyway.configure().dataSource("./aaa", "sa", null).load(); + 
7. Создаем два sql файла, один с таблицами и тд, другим вставляем данные + 
8. Подключаем бд к проекту Connection conn = DriverManager.getConnection(...); +
9. Можем удалить коллекции с тестовыми данными 
10. Создадим три DAO класса, 1 - с поиском юзера, 2 - нахождение заданной роли,3 - нахождение у пользователя такой роли и ресурса
11. Инжектим этb классы вместо коллекций в сервисы и в методах findUser, isUserHasRole, isRoleExist вызываем методы классов dao
12. Выборку в БД делаем через PreparedStatement
