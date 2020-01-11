insert into User (login, hash, salt) values ('admin', 'admin', 'salt1');
insert into User (login, hash, salt) values ('user1', 'user', 'salt2');
insert into User (login, hash, salt) values ('jdoe', 'sup3rpaZZ', 'salt3');
insert into User (login, hash, salt) values ('jrow', 'Qweqrty12', 'salt4');
insert into User (login, hash, salt) values ('xxx', 'yyy', 'salt5');

insert into Access (login, role, res) values ('admin', 'WRITE', 'АВ');
insert into Access (login, role, res) values ('admin', 'READ', 'AB.C');
insert into Access (login, role, res) values ('admin', 'READ', 'A.B.C');
insert into Access (login, role, res) values ('user1', 'EXECUTE', 'AB.CD.E');
insert into Access (login, role, res) values ('jdoe', 'READ', 'A');
insert into Access (login, role, res) values ('jdoe', 'WRITE', 'A.B');
insert into Access (login, role, res) values ('jrow', 'EXECUTE', 'A.B.C');
insert into Access (login, role, res) values ('jrow', 'EXECUTE', 'A.BC');