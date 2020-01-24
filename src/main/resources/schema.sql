create table if not exists Chat (
    user varchar(11) not null,
    message varchar(120)
);

create table if not exists User (
    realName varchar(20) not null,
    userName varchar(20) not null
)