USE jpa;

SELECT *
FROM customer;

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name, address, city, postal_code, country
FROM customer;

CREATE TABLE my_table20
(
    name  VARCHAR(30),
    money INT,
    primary key (name)
);

INSERT INTO my_table20
    (name, money)
VALUES ('a', 10000),
       ('b', 10000);

CREATE TABLE my_table21
(
    id          INT primary key AUTO_INCREMENT,
    name        VARCHAR(20),
    address     VARCHAR(20),
    inserted_at DATETIME DEFAULT NOW()
);
INSERT INTO my_table21
    (name, address)
VALUES ('kim', 'busan');

CREATE TABLE my_table22
(
    name    varchar(20),
    address varchar(20),
    country varchar(20),
    primary key (name)
);
Insert into my_table22
    (name, address, country)
VALUES ('kim', 'seoul', 'korean');
insert into my_table22
    (address, country)
values ('jeju', 'usa');

create table my_table23
(
    name    varchar(30),
    address varchar(30),
    country varchar(30),
    info    varchar(30),
    primary key (name, address)
);
CREATE TABLE my_table24
(
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    score    INT          NULL,
    name     VARCHAR(20)  NOT NULL,
    address  VARCHAR(200) NOT NULL,
    CONSTRAINT pk_my_table24 PRIMARY KEY (name, address)
);

# 복합키가 있는 my_table25 테이블 만들고 entity 만들어보기

# 복합키가 있는 Entity26 만들고 my_table26 만들어보기
create table my_table2525
(
    class_number   int,
    student_number int,
    name           varchar(20),
    score          int,
    primary key (class_number, student_number)
);
drop table my_table2525;

CREATE TABLE my_table25
(
    age     INT          NULL,
    phone   INT          NULL,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT pk_my_table25 PRIMARY KEY (name, address)
);

create table my_table26
(
    name    varchar(255),
    phone   int,
    address int,
    age     int,
    primary key (name, phone)
);

# foreign key (외래키, 참조키, FK)

# create table my_table27
# (
#     id            int primary key,
#     category_name varchar(30),
#     info          varchar(1000)
# );
#
# create table my_table28
# (
#     id           int primary key auto_increment,
#     product_name varchar(30),
#     price        int,
#     unit         varchar(30),
#     category_id  int not null,
#     foreign key (category_id) references my_table27(id)
# );
# foreign key (외래키, 참조키, FK)
CREATE TABLE my_table27
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(30),
    info          VARCHAR(1000)
);

CREATE TABLE my_table28
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(30),
    price        INT,
    unit         VARCHAR(30),
    category_id  INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES my_table27 (id)
);

create table my_table29
(
    id         int auto_increment primary key,
    first_name varchar(10),
    last_name  varchar(10),
    birth_date date
);

create table my_table30
(
    id          int auto_increment primary key,
    order_date  date,
    info        varchar(20),
    employee_id int,
    foreign key (employee_id) references my_table29 (id)
);

# 연습 : 29,30 엔티티 만들기
# repository 만들기
# insert 해보기
# select 해보기

# request handler method *4
# service method *4