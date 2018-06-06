//src
CREATE TABLE person (
id serial,
email character varying(255),
firstname character varying(255),
lastname character varying(255)
);
//dest
CREATE TABLE people (
id serial,
emailId character varying(255),
fname character varying(255),
lname character varying(255)
);

//src
CREATE TABLE organization (
id serial,
name character varying(255),
employee_count int,
startdate date,
revenue bigint
);


//dest
CREATE TABLE org (
id serial,
name character varying(255),
employee_count int
);

//dest
CREATE TABLE org_detail (
id serial,
name character varying(255),
startdate date,
revenue bigint
);

//src
CREATE TABLE emp (
id serial,
name character varying(255),
address character varying(255)
);
//src
CREATE TABLE emp_info (
id serial,
name character varying(255),
prj_name character varying(255),
salary int,
dob date
);

//dest
CREATE TABLE emp_info (
id serial,
name character varying(255),
address character varying(255),
prj_name character varying(255),
salary int,
dob date
);

//src
INSERT INTO person(email,firstname,lastname) VALUES ('raushan@triconinfotech.com','Raushan','Kumar'),('rakesh@triconinfotech.com','rakesh','kumar');

insert into organization(name,employee_count,startdate,revenue) values ('Tricon Infotech',500,now(),400000),('Tricon',500,now(),400000);

insert into emp(name,address) values('Raushan','Ejipura'),('Prem','Bangalore');
insert into emp_info(name,prj_name,salary,dob) VALUES ('Raushan','Medium',100,'30-12-1990'),('Prem','MEA',300,'30-12-1983');


//dest
INSERT INTO people(emailId,fname,lname) VALUES ('raushan@triconinfotech.com','Raushan','Kumar'),('rakesh@triconinfotech.com','rakesh','singh');

insert into org(name,employee_count) values ('Tricon Infotech',500),('Tricon',400);

insert into org_detail(name,startdate,revenue) values ('Tricon Infotech','12-02-2000',300000),('Tricon',now(),200000);
insert into emp_info(name,address,prj_name,salary,dob) VALUES ('Raushan','Koramangala','Medium',100,'30-12-1991'),('Prem','Bangalore','Multiple',400,'30-12-1983');