CREATE DATABASE blog;
USE blog;

CREATE TABLE blog(
id int primary key,
blogName varchar(50),
summary varchar(50),
content text,
author varchar(50),
timePost varchar(50)
);

CREATE TABLE Category (
id int primary key,
categoryName varchar(50)
);