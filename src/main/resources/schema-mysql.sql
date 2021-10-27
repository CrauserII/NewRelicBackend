--CREATE TABLE IF NOT EXISTS appUser (
--DROP TABLE appUser;
--DROP TABLE company;

CREATE TABLE IF NOT EXISTS appUser (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,

    company_Id INT
    );

CREATE TABLE IF NOT EXISTS company (
--CREATE TABLE company (
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    companyName VARCHAR(100) NOT NULL
    );