USE mydatabase;

CREATE TABLE table34
(
    name VARCHAR(1)
);
CREATE TABLE table35
(
    score INT
);
INSERT INTO table34
    (name)
values ('a'),
       ('b'),
       ('c'),
       ('d'),
       ('e');
INSERT INTO table35
    (score)
values (5),
       (4),
       (3),
       (2),
       (1);
SELECT *
FROM table34;
SELECT *
FROM table35;

# 행은 25개, 열 2개
SELECT *
FROM table34,
     table35;

# 행 616, 열 9
SELECT *
FROM w3schools.Products,
     w3schools.Categories;

SELECT *
FROM w3schools.Products
         JOIN
     w3schools.Categories;

# Cartesian Product (카테시안 곱)

CREATE TABLE table36
(
    '대회'  VARCHAR(20),
    '연도'  INT,
    '우승자' VARCHAR(30),
    PRIMARY KEY ('대회', '연도')
);
CREATE TABLE table37
(
    '우승자'  VARCHAR(30),
    '생년월일' VARCHAR(30),
    PRIMARY KEY ('우승자')
);
INSERT INTO table36
    (대회, 연도, 우승자)
VALUES ('D', '1998', 'chip'),
       ('I', '1998', 'al'),
       ('C', '1999', 'bob'),
       ('D', '1999', 'al'),
       ('I', '1999', 'chip');
INSERT INTO table37
    (우승자, 생년월일)
VALUES ('chip', '77-3-14'),
       ('al', '75-7-21'),
       ('chip', '68-9-28');

# CREATE TABLE table36
# (
#     `대회`  VARCHAR(20),
#     `연도`  INT,
#     `우승자` VARCHAR(30),
#     PRIMARY KEY (`대회`, `연도`)
# );
# CREATE TABLE table37
# (
#     `우승자`  VARCHAR(30),
#     `생년월일` VARCHAR(100),
#     PRIMARY KEY (`우승자`)
# );
# INSERT INTO table36
# (대회, 연도, 우승자)
# VALUES ('D', '1998', 'chip'),
#        ('I', '1998', 'al'),
#        ('C', '1999', 'bob'),
#        ('D', '1999', 'al'),
#        ('I', '1999', 'chip');
# INSERT INTO table37
# (우승자, 생년월일)
# VALUES ('chip', '77-3-14'),
#        ('al', '75-7-21'),
#        ('bob', '68-9-28');
#
# SELECT *
# FROM table36;
# SELECT *
# FROM table37;

# SELECT *
# FROM table36;
# SELECT *
# FROM table37;
#
# SELECT *
# FROM table36,
#      table37;

CREATE TABLE table36
(
    `대회`  VARCHAR(20),
    `연도`  INT,
    `우승자` VARCHAR(30),
    PRIMARY KEY (`대회`, `연도`)
);
CREATE TABLE table37
(
    `우승자`  VARCHAR(30),
    `생년월일` VARCHAR(100),
    PRIMARY KEY (`우승자`)
);
INSERT INTO table36
    (대회, 연도, 우승자)
VALUES ('D', '1998', 'chip'),
       ('I', '1998', 'al'),
       ('C', '1999', 'bob'),
       ('D', '1999', 'al'),
       ('I', '1999', 'chip');
INSERT INTO table37
    (우승자, 생년월일)
VALUES ('chip', '77-3-14'),
       ('al', '75-7-21'),
       ('bob', '68-9-28');

SELECT *
FROM table36;
SELECT *
FROM table37;

SELECT *
FROM table36,
     table37;

SELECT *
FROM table36
         JOIN
     table37
WHERE table36.우승자 = table37.우승자;

SELECT *
FROM table36
         JOIN
     table37
     ON table36.우승자 = table37.우승자;

# ALIAS : 별칭
SELECT `대회` AS congress, `연도` year, t6.`우승자`, `생년월일`
FROM table36 t6
         JOIN
     table37 AS t7
     ON t6.우승자 = t7.우승자;

#
SELECT *
FROM w3schools.Products;
SELECT *
FROM w3schools.Categories;

SELECT c.CategoryName, p.ProductName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName;

# 연습 :
# 공급자별 공급하는 상품 목록 조회

SELECT *
FROM w3schools.Products;
SELECT *
FROM w3schools.Suppliers;

SELECT s.SupplierID, p.ProductID
FROM w3schools.Suppliers s
         JOIN w3schools.Products p
              ON p.SupplierID = s.SupplierID
ORDER BY s.SupplierName, ProductName;

# 주문별 처리 직원
SELECT o.OrderDate, o.OrderID, e.FirstName, e.LastName
FROM w3schools.Orders o
         JOIN w3schools.Employees e
              ON o.EmployeeID = e.EmployeeID
WHERE e.EmployeeID = 3;

# 연습 :
# 1번 고객이 주문한 날짜들 조회

SELECT c.CustomerName, o.OrderDate
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              on o.CustomerID = c.CustomerID
WHERE c.CustomerID = 1
ORDER BY o.OrderDate;

# 주문이 20건 이상인 고객들
SELECT c.CustomerID, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              on o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(*) >= 20
ORDER BY c.CustomerID
;

# 연습
# 직원별 주문 처리 건수
SELECT e.EmployeeID, e.LastName, e.FirstName, COUNT(*) count
FROM w3schools.Orders o
         JOIN w3schools.Employees e
              ON e.EmployeeID = o.EmployeeID
WHERE OrderDate BETWEEN  '1997-01-01' AND '1997-12-31'
GROUP BY e.EmployeeID
ORDER BY count DESC;
;
# 카테고리별 상품의 평균가격
SELECT C.CategoryID, C.CategoryName, AVG(P.Price)
FROM w3schools.Categories C
         JOIN w3schools.Products P
             on C.CategoryID = P.CategoryID
GROUP BY C.CategoryID
ORDER BY C.CategoryID
;

# 예시 1: 공급자별 상품 목록
# sql
# 코드 복사
# SELECT s.SupplierID, p.ProductID
# FROM w3schools.Suppliers s         -- 기준: 공급자
#          JOIN w3schools.Products p          -- 연결: 상품
#               ON p.SupplierID = s.SupplierID
#     기준: 공급자
#
# 상품은 공급자에 종속 → JOIN 대상
#
# 예시 2: 주문별 처리 직원
# sql
# 코드 복사
# SELECT o.OrderDate, o.OrderID, e.FirstName, e.LastName
# FROM w3schools.Orders o           -- 기준: 주문
#          JOIN w3schools.Employees e        -- 연결: 직원
#               ON o.EmployeeID = e.EmployeeID
#     기준: 주문
#
# 직원은 주문의 담당자 → JOIN 대상
#
# 예시 3: 1번 고객의 주문 날짜
# sql
# 코드 복사
# SELECT c.CustomerName, o.OrderDate
# FROM w3schools.Orders o           -- 기준: 주문
#          JOIN w3schools.Customers c        -- 연결: 고객
#               ON o.CustomerID = c.CustomerID
# WHERE c.CustomerID = 1
#     기준: 주문 (OrderDate 때문에)
#
# 고객 정보는 부가적인 설명 → JOIN 대상
#
# 예시 4: 주문이 20건 이상인 고객
# sql
# 코드 복사
# SELECT c.CustomerID, COUNT(*)
# FROM w3schools.Orders o          -- 기준: 주문
#          JOIN w3schools.Customers c       -- 연결: 고객
#               ON o.CustomerID = c.CustomerID
# GROUP BY c.CustomerID
# HAVING COUNT(*) >= 20
#     기준: 주문 수 → Orders가 중심
#
# 고객은 JOIN 대상 (누가 주문했는지 알기 위해)
#
# 예시 5: 직원별 주문 처리 건수
# sql
# 코드 복사
# SELECT e.EmployeeID, e.LastName, e.FirstName, COUNT(*) count
# FROM w3schools.Orders o         -- 기준: 주문
#          JOIN w3schools.Employees e      -- 연결: 직원
#               ON o.EmployeeID = e.EmployeeID
# GROUP BY e.EmployeeID
#     기준: 주문 수
#
# 직원은 주문을 묶기 위한 대상 → JOIN
#
# 예시 6: 카테고리별 평균 상품 가격
# sql
# 코드 복사
# SELECT C.CategoryID, C.CategoryName, AVG(P.Price)
# FROM w3schools.Categories C      -- 기준: 카테고리
#          JOIN w3schools.Products P        -- 연결: 상품
#               ON C.CategoryID = P.CategoryID
#     기준: 카테고리
#
# 상품은 카테고리에 딸려 있음 → JOIN 대상
#
# 💡 결론: 이렇게 판단하자
# 질문	판단 기준
# 어떤 테이블에서 중심 데이터를 가져오려는가?	→ FROM에 넣기
# 어떤 테이블이 보조 정보인가?	→ JOIN에 넣기