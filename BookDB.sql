create table t_book(
  id int not null,
  author varchar2(100) not null,
  title varchar2(100) not null,
  description varchar2(255),
  pub_year number(4) not null,
  constraint t_book_pk primary key(id)
);

create sequence s_book;

create table t_book_users(
  id int not null,
  Username varchar2(100) not null,
  GivenPW varchar2(100) not null,
  constraint book_users_pk primary key(id)
);

alter table t_book_users add
constraint uniqueUsername UNIQUE(Username);

create sequence s_book_users;

create table t_book_roles(
  id int not null,
  Username varchar2(100) not null,
  role varchar2(100) not null,
  constraint book_roles_pk primary key(id)
);

alter table t_book_roles add
constraint uniqueUsernameRole UNIQUE(Username);

ALTER TABLE t_book_roles
MODIFY Role  DEFAULT 'reader';

create SEQUENCE s_book_roles;

select * from T_BOOK_USERS;
select * from T_BOOK_ROLES;

truncate table t_book_users;
truncate table t_book_roles;
