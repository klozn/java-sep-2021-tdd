CREATE SCHEMA switchtothesun;

SET search_path TO switchtothesun;

create table CONTINENT
(
    ID   integer       not null,
    NAME text NOT NULL UNIQUE,
    CONSTRAINT PK_CONTINENT primary key (ID)
);
create sequence continent_seq start with 1 increment by 1;

create table COUNTRY
(
    ID              integer       NOT NULL,
    NAME            text NOT NULL UNIQUE,
    FK_CONTINENT_ID integer,
    CONSTRAINT FK_COUNTRY_CONTINENT foreign key (FK_CONTINENT_ID) references CONTINENT (ID),
    CONSTRAINT PK_COUNTRY primary key (ID)
);
create sequence country_seq start with 1 increment by 1;

create table ATTRACTION
(
    ID            integer       NOT NULL,
    NAME          text NOT NULL,
    TYPE          text NOT NULL,
    FK_COUNTRY_ID integer       NOT NULL,
    CONSTRAINT FK_ATTRACTION_COUNTRY foreign key (FK_COUNTRY_ID) references COUNTRY (ID),
    CONSTRAINT PK_ATTRACTION primary key (ID)

);
create sequence attraction_seq start with 1 increment by 1;

create table TOURIST
(
    ID   integer       NOT NULL,
    NAME text NOT NULL,
    CONSTRAINT PK_TOURIST primary key (ID)
);
create sequence tourist_seq start with 1 increment by 1;

create table metadata
(
    ID               integer not null,
    NUMBER_OF_VISITS integer not null,
    CONSTRAINT PK_METADATA PRIMARY KEY (ID)
);

insert into CONTINENT(ID, NAME)
VALUES (nextval('continent_seq'), 'Europe');
insert into CONTINENT(ID, NAME)
VALUES (nextval('continent_seq'), 'Asia');
insert into CONTINENT(ID, NAME)
VALUES (nextval('continent_seq'), 'Africa');
insert into CONTINENT(ID, NAME)
VALUES (nextval('continent_seq'), 'North America');
insert into CONTINENT(ID, NAME)
VALUES (nextval('continent_seq'), 'South America');
insert into CONTINENT(ID, NAME)
VALUES (nextval('continent_seq'), 'Australia');

insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (nextval('country_seq'), 'France', (select id from CONTINENT where NAME = 'Europe'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (nextval('country_seq'), 'Italy', (select id from CONTINENT where NAME = 'Europe'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (nextval('country_seq'), 'Spain', (select id from CONTINENT where NAME = 'Europe'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (nextval('country_seq'), 'Kenya', (select id from CONTINENT where NAME = 'Africa'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (nextval('country_seq'), 'India', (select id from CONTINENT where NAME = 'Asia'));
insert into COUNTRY(ID, NAME, FK_CONTINENT_ID)
values (nextval('country_seq'), 'United States', (select id from CONTINENT where NAME = 'North America'));

insert into ATTRACTION(id, name, type, fk_country_id)
values (nextval('attraction_seq'), 'The Eifel Tower', 'MONUMENT', (select id from COUNTRY where NAME = 'France'));
insert into ATTRACTION(id, name, type, fk_country_id)
values (nextval('attraction_seq'), 'Côte d''azur', 'BEACH', (select id from COUNTRY where NAME = 'France'));
insert into ATTRACTION(id, name, type, fk_country_id)
values (nextval('attraction_seq'), 'The Colosseum', 'MONUMENT', (select id from COUNTRY where NAME = 'Italy'));
insert into ATTRACTION(id, name, type, fk_country_id)
values (nextval('attraction_seq'), 'Venice', 'CITY', (select id from COUNTRY where NAME = 'Italy'));
insert into ATTRACTION(id, name, type, fk_country_id)
values (nextval('attraction_seq'), 'Seville', 'CITY', (select id from COUNTRY where NAME = 'Spain'));

insert into metadata(ID, NUMBER_OF_VISITS)
values (0, 0);

-- drop table TOURIST;
-- drop sequence tourist_seq;
-- drop table ATTRACTION;
-- drop sequence attraction_seq;
-- drop table COUNTRY;
-- drop sequence country_seq;
-- drop TABLE CONTINENT;
-- drop sequence continent_seq;
-- drop table metadata;
