USE jpa;

SELECT *
FROM w3schools.Customers;
DESC w3schools.Customers;

CREATE TABLE customer
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    contact_name  VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255)
);

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT customername,
       contactname,
       address,
       city,
       postalcode,
       country
FROM w3schools.Customers;

SELECT *
FROM jpa.customer;


DESC w3schools.Employees;
CREATE TABLE employee
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    last_name  VARCHAR(255),
    first_name VARCHAR(255),
    birth_date DATE,
    photo      VARCHAR(255),
    notes      VARCHAR(5000)
);

INSERT INTO jpa.employee
    (last_name, first_name, birth_date, photo, notes)
SELECT LastName, FirstName, BirthDate, Photo, Notes
FROM w3schools.Employees;

# 연습 :
# employee 테이블에 매핑되는 Entity17 entity 만들기
# Entity17Repository 만들기
# get /main21/sub3 request handler method 만들고
# service.action3() 메소드 만들고
## entity17(employee) 테이블의 모든 레코드 조회하고 size 출력하기

DESC w3schools.Suppliers
;
CREATE TABLE supplier
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255),
    contact_name  VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255),
    phone         VARCHAR(255)
);
INSERT INTO supplier
(supplier_name, contact_name, address, city, postal_code, country, phone)
SELECT suppliername, contactname, address, city, postalcode, country, phone
FROM w3schools.Suppliers;

SELECT *
FROM supplier;

DESC w3schools.Orders;
CREATE TABLE orders
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    employee_id INT,
    order_date  DATE,
    shipper_id  INT
);
INSERT INTO orders
    (customer_id, employee_id, order_date, shipper_id)
SELECT CustomerID, EmployeeID, OrderDate, ShipperID
FROM w3schools.Orders;

SELECT *
FROM orders;

DESC w3schools.Products;
CREATE TABLE product
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255),
    supplier_id INT,
    category_id INT,
    unit VARCHAR(255),
    price DEC(10,2)
);
INSERT INTO product
(product_name, supplier_id, category_id, unit, price)
SELECT ProductName, SupplierID, CategoryID, Unit, Price
FROM w3schools.Products