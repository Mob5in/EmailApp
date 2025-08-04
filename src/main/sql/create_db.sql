create database Email_Project_db;

use Email_Project_db;

create table User(
    id int primary key auto_increment,
    name nvarchar(100),
    email nvarchar(255) unique,
    password nvarchar(100)
);

CREATE TABLE Emails (
    code CHAR(6) PRIMARY KEY,
    sender_id INT NOT NULL,
    subject VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    sent_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES User(id)
);

CREATE TABLE Email_recipients (
    id int primary key auto_increment,
    email_code CHAR(6),
    recipient_id INT,
    is_read BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (email_code) REFERENCES Emails(code),
    FOREIGN KEY (recipient_id) REFERENCES User(id)
);


select *
from Emails;

select *
from Email_recipients;


select *
from User;

drop table user;
drop table Email_recipients;
drop table  Emails;
