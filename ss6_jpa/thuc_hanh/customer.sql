CREATE DATABASE customer;
USE customer;

CREATE TABLE customer(
id int primary key auto_increment,
name varchar(50),
email varchar(50) Not null,
address varchar(50) 
);

INSERT INTO customer (name,email,address) VALUES ('Nguyễn Văn A', 'nva@123', 'Quảng Trị');
INSERT INTO customer (name,email,address) VALUES ('Nguyễn Văn B', 'nvb@234', 'Sài Gòn');
INSERT INTO customer (name,email,address) VALUES ("Nguyễn Văn C", "nvc@345", "Đà Nẵng");

