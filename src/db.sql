create database BankManagementSystem;

use BankManagementSystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20),
                    email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25),
                    state varchar(25), pincode varchar(20));

show tables;

--execute query
select * from signup;

--making of 2nd form
create table signup2(formno varchar(20), religion varchar(20), category varchar(20), education varchar(20),
                     income varchar(20), occupation varchar(20), isSenior varchar(20), isExisting varchar(20),
                     pan varchar(20), aadhar varchar(20));

show tables;

select * from signup2;

--making of 3rd form
create table signup3(accountType varchar(40), cardNum varchar(25), pinNum varchar(10), facility varchar(100), formno varchar(20));

create table login(cardNum varchar(25), pinNum varchar(10), formno varchar(20));

show tables;

select * from signup3;
