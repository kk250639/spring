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
VALUES ('철수', '컴퓨터공학', '자료구조', '김교수'),
       ('철수', '컴퓨터공학', '운영체제', '박교수'),
       ('영희', '경영학', '회계학', '이교수'),
       ('민수', '컴퓨터공학', '자료구조', '김교수'),
       ('민수', '컴퓨터공학', '네트워크', '최교수'),
       ('민수', '컴퓨터공학', '데이터베이스', '정교수')
DESC table99;
SELECT *
FROM table99;
DROP TABLE table99;

#연습
# 1996-09 월 평균 처리 금액 보다 높은 금액을 처리한 직원 목록
## 구해야할 것 -> 평균 처리 금액(총 처리 금액(갯수와 금액), 직원수)->
## 직원별 처리 금액->평균금액보다 높은 직원 조회

# 1. 총처리 금액
SELECT SUM(OD.Quantity*P.Price)
FROM w3schools.Orders O
         JOIN w3schools.OrderDetails OD # 주문 전체 내용을 파악
              ON O.OrderID = OD.OrderID
         JOIN w3schools.Products P      # 가격과 수량
              ON OD.ProductID = P.ProductID
WHERE O.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';

# 2. 총 인원
SELECT COUNT(DISTINCT EmployeeID)
FROM w3schools.Orders O
WHERE O.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'

SELECT COUNT(EmployeeID)
FROM w3schools.Orders;

SELECT COUNT(DISTINCT EmployeeID)
FROM w3schools.Orders;

SELECT E.EmployeeID, COUNT(*) AS 주문건수
FROM w3schools.Orders O
    JOIN w3schools.Employees E
        on O.EmployeeID = E.EmployeeID
GROUP BY E.EmployeeID
ORDER BY 주문건수 DESC;

# 전체 주문 건수
# SELECT COUNT(E.EmployeeID)
# FROM w3schools.Employees E
#     JOIN w3schools.Orders O
#         ON E.EmployeeID = O.EmployeeID
# WHERE O.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';