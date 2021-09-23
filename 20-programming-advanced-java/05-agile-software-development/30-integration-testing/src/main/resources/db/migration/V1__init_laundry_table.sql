create sequence laundry_seq start with 1 increment by 1;

create table laundry
(
    id            integer,
    laundry_type  varchar(255),
    owner         varchar(255),
    description   varchar(255),
    creation_date timestamp,
    primary key (id)
);
