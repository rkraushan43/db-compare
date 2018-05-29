CREATE TABLE person (
id serial,
email character varying(255),
firstname character varying(255),
lastname character varying(255)
);

CREATE TABLE people (
id serial,
emailId character varying(255),
fname character varying(255),
lname character varying(255)
);

INSERT INTO person(email,firstname,lastname) VALUES ('raushan@triconinfotech.com','Raushan','Kumar'),('rakesh@triconinfotech.com','rakesh','kumar');

INSERT INTO people(emailId,fname,lname) VALUES ('raushan@triconinfotech.com','Raushan','Kumar'),('rakesh@triconinfotech.com','rakesh','singh');