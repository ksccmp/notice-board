create database board;

create table customerinformation(
	id varchar(30) primary key,
    password varchar(30),
    name varchar(30),
    number varchar(30)
);

create table boardinformation (
	num int unsigned not null auto_increment primary key,
	id varchar(30) references customerinformation(id),
    title varchar(100),
    contents varchar(500),
    regdate date
);

insert into boardinformation(id, title, contents, regdate) values ('asd', '첫 번재', '첫 번째 내용입니다.', '2019-09-24');
insert into boardinformation(id, title, contents, regdate) values ('qwe', '두 번재', '두 번째 내용입니다.', '2019-09-24');
insert into boardinformation(id, title, contents, regdate) values ('zxc', '세 번재', '세 번째 내용입니다.', '2019-09-24');

select * from boardinformation limit 0, 5;

set charset utf8;

alter database board default character set utf8;
alter table customerinformation convert to character set utf8;
alter table boardinformation convert to character set utf8;

select * from customerinformation;
select * from boardinformation;

delete from customerinformation;
delete from boardinformation;

drop table customerinformation;
drop table boardinformation;