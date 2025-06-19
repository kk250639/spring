USE jpa;
CREATE TABLE Member
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    username   VARCHAR(10) UNIQUE,
    password   VARCHAR(16),
    nickname   VARCHAR(10),
    created_at DATETIME
);

CREATE TABLE Post
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    title     VARCHAR(15),
    content   VARCHAR(1000),
    writer_id INT,
    ldt       DATETIME,
    FOREIGN KEY (writer_id) REFERENCES Member (id)
);