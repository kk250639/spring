# DATABASE : 테이블을 모아놓은 공간
# CREATE DATABASE : 데이터베이스 만들기
CREATE DATABASE mydatabase;

# database(schema) 사용하기
USE mydatabase;

#CREATE TABLE : 테이블 만들기
CREATE TABLE table1
(
    id int
);

#
USE mydatabase;
USE w3schools;
SELECT *
FROM Customers;

SELECT *
FROM w3schools.Customers;

USE mydatabase;

#
CREATE TABLE my_table2 # 테이블명
(# 둥근괄호 안에서 컬럼명 타입 나열,
    name    varchar(255),
    country varchar(255),
    phone   varchar(255)
);
INSERT INTO table2
    (name, country, phone)
VALUES ('트럼프', '미국', '2323');
SELECT *
FROM table2;

# 테이블명, 컬럼명 작성 규칙
# 소문자, _ (lower_snake_case)
CREATE TABLE my_table1
(
    name            VARCHAR(255),
    address         VARCHAR(255),
    last_name       VARCHAR(255),
    nick_name       VARCHAR(255),
    home_address    VARCHAR(255),
    my_work_address VARCHAR(255)
);

# 연습
# id, name, address, team 컬럼이 있는 table3 만들기
# 2개의 레코드 입력(insert) 하기
CREATE TABLE my_table3
(
    id VARCHAR(255),
    name VARCHAR(255),
    address VARCHAR(255),
    team VARCHAR(255)
);
INSERT INTO my_table3
(id, name, address, team)
VALUES ('1','son','seoul','토트넘');
INSERT INTO my_table3
(id, name, address, team)
VALUES ('5','kim','busan','red');

#DROP TABLE : 테이블 삭제하기 (매우 주의!!!)
DROP TABLE my_table1;
DROP TABLE my_table3;
