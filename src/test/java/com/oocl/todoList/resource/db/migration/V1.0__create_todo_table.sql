CREATE TABLE if NOT EXISTS todo
(
    id   int          not null auto_increment primary key,
    content varchar(255) not null,
    status boolean
);