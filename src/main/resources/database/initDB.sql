CREATE TABLE IF NOT EXISTS clients
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    phone VARCHAR(50)  NOT NULL
);
-- DROP TABLE IF EXISTS clients;