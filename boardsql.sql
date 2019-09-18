create database board;

create table customerinformation(
	id varchar(30) primary key,
    password varchar(30),
    name varchar(30),
    number varchar(30)
);

set charset utf8;

alter database board default character set utf8;
alter table customerinformation convert to character set utf8;

select * from customerinformation;

delete from customerinformation;

drop table customerinformation;