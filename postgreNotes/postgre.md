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
               
               
 ### timescaledb extension
 - to enlist the extensios

                    \dx       
               
               
- TimescaleDB provides the ability to schedule the execution of custom stored procedures with user-defined actions. 
    
 ## time-scale installation - check the link below
 - https://packagecloud.io/timescale/timescaledb/packages/ubuntu/jammy/timescaledb-2-postgresql-14_2.10.3~ubuntu22.04_arm64.deb?distro_version_id=237

## after this 
- time scale automatically install posgresql-14

## connecting with postgresql to timescaledb
- psql - 

          show config_file;
          \l
          
         
- locally - 
## to connect timescaledb
          
            echo "shared_preload_libraries = 'timescaledb'" >> /etc/postgresql/14/main/postgresql.conf
            
            systemctl restart postgresql
            
- psql - 
          
            CREATE database tsdb;
            \c tsdb
            CREATE EXTENSION IF NOT EXISTS timescaledb;
            \dx
- output you have 
![Screenshot (283)](https://user-images.githubusercontent.com/99471014/236690713-40f8966f-a55e-417f-bfde-9523b65d6793.png)



 ## difference timescaledb vs postgresql
 
 - At 200 million rows the insert rate in PostgreSQL is an average of 30K rows per second and only gets worse; at 1 billion rows, it's averaging 5K rows per second. On the other hand, TimescaleDB sustains an average insert rate of 111K rows per second through 1 billion rows of data–a 20x improvement.
 

## database tunning
- it helps to running application faster,  faster means throughput(response-time) 
- avoid transaction that create bottleneck "or" avoid query that running unnecessarily.

# activities used to optimise / homogenize performance of database
- good databse design - distribute the db into multiple disk avoid disk overload and increase throughput.

#DBMS tunning 
- refers to dba expert, refers to configure the memory and processing resources.

                    
                    
