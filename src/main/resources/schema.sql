/* Drop Tables */
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
/* Create Tables */
CREATE TABLE category
 (
     id INTEGER PRIMARY KEY,
     name VARCHAR(128)
 );

 CREATE TABLE book
 (
     id INTEGER PRIMARY KEY,
     name VARCHAR(128),
     price INTEGER,
     category_id INTEGER,
     CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category(id)
 );