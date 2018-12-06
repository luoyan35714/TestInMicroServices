drop table product if exists;

create table product 
(
	id integer, 
	name varchar(64),
	description varchar(128),
	storage integer, 
	primary key (id)
);
