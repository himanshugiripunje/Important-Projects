## postgre notes
login via su - postgres
- show databases

          \l
- show users and their permissions

          \du
          
          
- show tabel

          \d
          
- create user with role, superuser, 
          
          CREATE USER parth WITH ENCRYPTED PASSWORD 'redhat';


- create database;

          CREATE DATABSE mydb;
          
- granting privileges to user

           GRANT ALL PRIVILAGES ON DATABASE mydb TO himu;

-  connct with databse

           \c db_name;
           
           
-  create table - **in that need to specify primary key**, 
-         column_name data_type,

                    CREATE TABLE tabe_name (
              emp_id 	INT PRIMARY KEY,
              first_name VARCHAR(50) NOT NULL,
              last_name VARCHAR(50) NOT NULL,
              gender CHAR(1),
              birthdate DATE,
              email VARCHAR(100) UNIQUE,
              salary INT
          );
          
          
  - need to see these tables = *to view relation*
                  
                   \d
     
- insert the data inside table
                   
                   INSERT INTO employee
                    VALUES(1,'Annie','Smith','F', DATE '1988-01-09', 'ani@email.com',5000);
                    
- view that data in the table as well

               SELECT * FROM table_name;
               
               
- TimescaleDB provides the ability to schedule the execution of custom stored procedures with user-defined actions. 
               
                     
                    
                    
