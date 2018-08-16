# Spring-RestFul-Apis-with-Cassandra
Spring Api development with Cassandra

Create keyspace and table in cassandra with following ddls
CREATE KEYSPACE "mydb"
WITH replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

create table product(
	id text primary key,
	description text,
	name text,
	price text
);

and use following endpoints to access 
for post 
localhost:8080/api/create
for get
localhost:8080/api/get/{id}
for get all 
localhost:8080/api/getall
for delete all
localhost:8080/api/deleteall
for delete by id 
localhost:8080/api/delete/{id}
for update 
localhost:8080/api/update/{id}

