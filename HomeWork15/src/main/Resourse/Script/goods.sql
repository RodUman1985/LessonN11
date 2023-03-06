create table goods
{
 id INT,
 tittle VARCHAR(50),
 price DOUBLE
};

create table order_goods
{
 id INT AUTO_INCREMENT,
order_id INT,
good_id INT
};
create table orderrs
{
 id INT AUTO_INCREMENT,
 user_id INT ,
 price DOUBLE
};
create table users
{
 id int AUTO_INCREMENT ,
 userNamee VARCHAR(50),
 password VARCHAR(50)
};
insert into goods (id,tittle,price)
values(1,lazgan,100);
insert into goods (id,tittle,price)
values(2,bolter,100);
insert into goods (id,tittle,price)
values(3,chainsword,100);
insert into goods (id,tittle,price)
values(4,chainaxe,100);
insert into goods (id,tittle,price)
values(1,power swoord,100);
