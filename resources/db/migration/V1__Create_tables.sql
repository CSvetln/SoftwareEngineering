CREATE TABLE User (
  login VARCHAR(25) PRIMARY KEY NOT NULL,
  hash VARCHAR(max) NOT NULL,
  salt VARCHAR(max) NOT NULL
);

CREATE TABLE Access (
    login VARCHAR(25) NOT NULL,
    role VARCHAR(25) NOT NULL,
    res VARCHAR(max) NOT NULL,
    FOREIGN KEY (login) REFERENCES User (login)
);

CREATE TABLE Node(
    id INT PRIMARY KEY AUTO_INCREMENT,
    parent VARCHAR(25) NOT NULL,
    value VARCHAR(25) NOT NULL,
    path VARCHAR(max) NOT NULL
 );