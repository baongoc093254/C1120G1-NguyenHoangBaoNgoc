use user;
create table users(
 id int auto_increment primary key,
 `name` nvarchar(255) not null,
 email varchar(120) not null,
 country varchar(50)
);