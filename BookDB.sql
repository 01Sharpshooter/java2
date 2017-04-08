create table t_book_users(
  id int not null,
  Username varchar2(100) not null,
  GivenPW varchar2(100) not null,
  GivenRole varchar2(20) default 'reader',
  constraint book_users_pk primary key(id)
);

alter table t_book_users add
constraint uniqueUsername UNIQUE(Username);

create sequence s_book_users;

create table t_book_roles(
  id int not null,
  Username varchar2(100) not null,
  role varchar2(100) not null,
  constraint book_users_pk primary key(id)
);

alter table t_book_roles add
constraint uniqueUsername UNIQUE(Username);

create SEQUENCE s_book_roles;

select * from T_BOOK_USERS;
select * from T_BOOK_ROLES;
