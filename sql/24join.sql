USE mydatabase;

CREATE TABLE table38
(
    id INT
);
INSERT INTO table38
    (id)
Values (9),
       (8),
       (8);

SELECT *
FROM table34;
SELECT *
FROM table35;
SELECT *
FROM table38;

SELECT *
FROM table34 t34
         JOIN table35 t35
         JOIN table38 t38;
SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
         JOIN w3schools.Suppliers s
WHERE p.CategoryID = c.CategoryID
  AND p.SupplierID = s.SupplierID
;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
;

# 카테고리별 공급자 정보
SELECT DISTINCT s.SupplierName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY s.SupplierName
;

SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s
              ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;
;

# 연습 :
## 1996-07-05 에 주문된 상품명 목록
# Orders, OrderDetails, Products
SELECT o.OrderDate, p.ProductName
FROM w3schools.OrderDetails od
         JOIN w3schools.Orders o
              ON od.OrderID = o.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE OrderDate = '1996-07-05'
ORDER BY p.ProductName;

#** b
SELECT o.OrderDate, p.ProductName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails OD
              on o.OrderID = OD.OrderID
         JOIN w3schools.Products p
              on OD.ProductID = p.ProductID
WHERE OrderDate = '1996-07-05'
ORDER BY p.ProductName;

# 연습
# Tofu 상품을 어떤 고객이 언제 주문했는지 조회
# Orders, Products, Customers, OrderDetails


SELECT o.OrderDate, P.ProductName, C.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails OD
              on o.OrderID = OD.OrderID
         JOIN w3schools.Products P
              on OD.ProductID = P.ProductID
         JOIN w3schools.Customers C
              on o.CustomerID = C.CustomerID
WHERE ProductName = 'Tofu'
ORDER BY o.OrderDate;

#** b
SELECT p.ProductName, C.CustomerName, O.OrderDate
FROM w3schools.Products p
         JOIN w3schools.OrderDetails OD
              on p.ProductID = OD.ProductID
         JOIN w3schools.Orders O
              on OD.OrderID = O.OrderID
         JOIN w3schools.Customers C
              on O.CustomerID = C.CustomerID
WHERE ProductName = 'Tofu'
ORDER BY C.CustomerName, O.OrderDate;

# WHERE ProductName = 'Tofu'
SELECT p.ProductName, C.CustomerName, O.OrderDate
FROM w3schools.Products p
         JOIN w3schools.OrderDetails OD
              on p.ProductID = OD.ProductID
         JOIN w3schools.Orders O
              on OD.OrderID = O.OrderID
         JOIN w3schools.Customers C
              on O.CustomerID = C.CustomerID
WHERE p.ProductID = 14 #조건에 사용되는 컬럼들은 PK 사용할 수록 성능이 좋음
ORDER BY C.CustomerName, O.OrderDate;

# 연습
# 우수 고객 선정 조회
# 고객별 주문 금액
# Orders, OrderDetails, Products, Customers
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC;

SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON p.ProductID = od.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC;

# 연습
# 1997-09 월에 가장 많은 주문(가격 기준)을 처리한 직원 조회
# Employees, Orders, OrderDetails, Products
SELECT e.FirstName, e.LastName, SUM(P.Price * OD.Quantity) 합
FROM w3schools.Orders o
         JOIN w3schools.Employees e
              on o.EmployeeID = e.EmployeeID
         JOIN w3schools.OrderDetails OD
              on o.OrderID = OD.OrderID
         JOIN w3schools.Products P
              on OD.ProductID = P.ProductID
WHERE OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID
ORDER BY 합 DESC;

SELECT e.FirstName, e.LastName, SUM(P.Price * OD.Quantity) 합
FROM w3schools.Employees e
         JOIN w3schools.Orders O on e.EmployeeID = O.EmployeeID
         JOIN w3schools.OrderDetails OD on O.OrderID = OD.OrderID
         JOIN w3schools.Products P on OD.ProductID = P.ProductID
WHERE OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID
ORDER BY 합 DESC;

#1998년 1월 한 달 동안
#**상품을 가장 많이 판매한 직원(수량 기준)**의
#이름과 총 판매 수량을 조회하시오.
#📌 사용 테이블: Employees, Orders, OrderDetails
SELECT e.LastName, e.FirstName, SUM(od.Quantity)
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
WHERE OrderDate BETWEEN '1998-01-01' AND '1998-01-31'
GROUP BY e.EmployeeID
ORDER BY SUM(od.Quantity) DESC
limit 1;
