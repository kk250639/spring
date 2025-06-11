CREATE TABLE table99
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(10),
    department VARCHAR(20),
    subject    VARCHAR(20),
    proffessor VARCHAR(10)
);
INSERT INTO table99
    (name, department, subject, proffessor)
VALUES ('철수', '컴퓨터공학', '자료구조', '김교수');
INSERT INTO table99
    (name, department, subject, proffessor)
VALUES ('철수', '컴퓨터공학', '운영체제', '박교수');
INSERT INTO table99
    (name, department, subject, proffessor)
VALUES ('영희', '경영학', '회계학', '이교수');
INSERT INTO table99
    (name, department, subject, proffessor)
VALUES ('민수', '컴퓨터공학', '자료구조', '김교수');
INSERT INTO table99
    (name, department, subject, proffessor)
VALUES ('민수', '컴퓨터공학', '네트워크', '최교수');
INSERT INTO table99
    (name, department, subject, proffessor)
VALUES ('민수', '컴퓨터공학', '데이터베이스', '정교수');

DESC table99;
SELECT *
FROM table99;
DROP TABLE table99;