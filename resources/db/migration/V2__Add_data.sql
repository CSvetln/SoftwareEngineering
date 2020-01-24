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

UPDATE User SET hash = '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918' where login = 'admin';
UPDATE User SET hash = '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb' where login = 'user1';
UPDATE User SET hash = 'eec5c06e5c503b064a929aca052ae979ae6f47ba277b548cf5cc5746a7b8f5b4' where login = 'jdoe';
UPDATE User SET hash = '50c3db53e1fa2f6a359d8d15df8cad5e1422a396a146621402f89ca076dc8f44' where login = 'jrow';
UPDATE User SET hash = 'cd2eb0837c9b4c962c22d2ff8b5441b7b45805887f051d39bf133b583baf6860' where login = 'xxx';