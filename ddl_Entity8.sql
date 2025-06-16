CREATE TABLE my_table8
(
    id          INT AUTO_INCREMENT NOT NULL,
    address     VARCHAR(255)       NULL,
    salary      DOUBLE             NULL,
    inserted_at datetime           NULL,
    hire_date   date               NULL,
    CONSTRAINT pk_my_table8 PRIMARY KEY (id)
);