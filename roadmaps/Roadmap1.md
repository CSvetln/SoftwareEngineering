План:
1.	Создадим перечисление Roles, в котором опишем роли.
2. Создадим класс Access(login: String, role: Roles, res: String)
3.	Список List(Access(login: admin, role: WRITE, res: АВ), Access(login: admin, role: READ, res: AB.C), Access(login: User1, role: EXECUTE, res: AB.CD.E))
4.	Тестирование
5.	Обычные
6.	-login “admin” –pass “admin”  -res “АВ.CD” –role “WRITE” -> 0
7.	-login “admin” –pass “admin”  -res “АВ.CD.E” –role “WRITE” -> 0
8.	-login “admin” –pass “admin”  -res “АВ.C” –role “READ” -> 0
9.	-login “user1” –pass “user”  -res “АВ.CD.E” –role “EXECUTE” -> 0
10.	Граничные
11.	-login “admin” –pass “admin” –role “WRITE” -res “АВ”  -> 0
12.	-login “admin” –pass “admin” –role “WRITE” 
(в таком случае мы договорились, что считать будто пользователь ввел только логин и пароль, и код возврата тоже ноль, как тогда проверить правильность?)
13.	Ошибочные
14.	-login “admin” –pass “admin”  -res “АВ” –role “WRREAD” -> 5
15.	-login “user1” –pass “user”  -res “АВ” –role “EXECUTE” -> 6
16.	login “user1” –pass “user”  -res “АВ” –role “READ” -> пользователь обращается не к своей роли

17.	Изменим класс Params, добавим поля role и res, и также будем разбирать что введено
18.	Добавим в класс ValidateService метод  isRoleExist (role: String):Boolean
19.	Форматируем, тестим, коммитим
20.	Добавим в класс ValidateService метод  isUserHasRole(login: String, role: Roles, res: String):Boolean
Тут проверяем есть у пользователя роль, к которой он пытается обратиться
21.	Форматируем, тестим, коммитим
1. Напишем еще один скрипт
2. Обычный
3. -login admin -pass admin -res AB -role WRITE -ds 2015-12-01 -de 2015-12-02 -vol 15 -> 0
4. Граничный
5. -login admin -pass admin -res AB -role WRITE -ds 2015-12-02 -de 2015-12-01 -vol 15 -> 0
6. Ошибочные
7. -login admin -pass admin -res AB -role WRITE -ds 2015 -de 2015 -vol 15 -> 7
8. -login admin -pass admin -res AB -role WRITE -ds 2015-12-02 -de 2015-12-01 -vol 0.2 -> 7
9. -login admin -pass admin -res AB -role WRITE -ds 2015-12-02 -de 2015-12-01 -vol many -> 7

11. Добавим в Params поля ds, de, vol
/*Форматируем, тестим, коммитим*/
12. Добавим в Params метод аккаунтинга fun accounting():Int 
/*Форматируем, тестим, коммитим*/
13. Добавим в ValidateService метод isDateValid(ds, de):Bool
/*Форматируем, тестим, коммитим*/
14. Добавим в ValidateService метод isVolValid(vol):Bool
/*Форматируем, тестим, коммитим*/
