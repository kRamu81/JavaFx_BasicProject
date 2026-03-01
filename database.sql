

CREATE DATABASE student_fx_db;
USE student_fx_db;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(100)
);

select * from student;
