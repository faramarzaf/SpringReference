/*create table person
(
id integer not null ,
name varchar(255) not null,
location varchar(255) not null,
birth_date timestamp,
primary key(id)
);
*/

/* we removed the create sql query because in jpa we announced
 @Entity ant this annotation will automatically generate the tabel for us
 but when you use SpringJDBC the above query should be uncommented
 */

/*create table EMPLOYEE
(
id integer not null ,
name varchar(255) not null,
location varchar(255) not null,
birth_date timestamp,
primary key(id)
);
*/



INSERT INTO EMPLOYEE(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'Faramarz', 'Tehran', sysdate());

INSERT INTO EMPLOYEE(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10002, 'Jon', 'New york', sysdate());

INSERT INTO EMPLOYEE(ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10003, 'Peter', 'Moscow', sysdate());




