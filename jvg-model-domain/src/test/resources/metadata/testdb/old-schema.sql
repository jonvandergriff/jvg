--alter table PERSON drop constraint FK8C768F5562A11578;
--alter table PERSON drop constraint FK8C768F5533196B27;
--alter table PERSON_DOCUMENT drop constraint FKA244D2C572966ACF;
--alter table PERSON_DOCUMENT drop constraint FKA244D2C58C64AA2C;
--alter table USERDETAILS_PERSONAUTHORITY drop constraint FKFA674F2688B1D55E;
--alter table USERDETAILS_PERSONAUTHORITY drop constraint FKFA674F2626C21929;
drop table DEMOGRAPHIC if exists;
drop table DOCUMENT if exists;
drop table PERSON if exists;
drop table PERSONAUTHORITY if exists;
drop table PERSON_DOCUMENT if exists;
drop table USERDETAILS if exists;
drop table USERDETAILS_PERSONAUTHORITY if exists;

--create tables

CREATE TABLE demographic 
  ( 
     demographic_id VARCHAR(255) NOT NULL, 
     NAME           VARCHAR(255), 
     updt_dt_tm     TIMESTAMP NOT NULL, 
     updt_task      VARCHAR(255) NOT NULL, 
     updt_user      VARCHAR(255) NOT NULL, 
     primary key (demographic_id), 
     UNIQUE (demographic_id) 
  ); 

CREATE TABLE document 
  ( 
     document_id VARCHAR(255) NOT NULL, 
     content     LONGVARCHAR, 
     updt_dt_tm  TIMESTAMP NOT NULL, 
     updt_task   VARCHAR(255) NOT NULL, 
     updt_user   VARCHAR(255) NOT NULL, 
     primary key (document_id), 
     UNIQUE (document_id) 
  ); 

CREATE TABLE person 
  ( 
     person_id         VARCHAR(255) NOT NULL, 
     updt_dt_tm        TIMESTAMP NOT NULL, 
     updt_task         VARCHAR(255) NOT NULL, 
     updt_user         VARCHAR(255) NOT NULL, 
     demographic_id_fk VARCHAR(255), 
     userdetails_id_fk VARCHAR(255), 
     primary key (person_id), 
     UNIQUE (person_id) 
  ); 

CREATE TABLE personauthority 
  ( 
     personauthority_id VARCHAR(255) NOT NULL, 
     authority          VARCHAR(255), 
     updt_dt_tm         TIMESTAMP NOT NULL, 
     updt_task          VARCHAR(255) NOT NULL, 
     updt_user          VARCHAR(255) NOT NULL, 
     primary key (personauthority_id), 
     UNIQUE (personauthority_id) 
  ); 

CREATE TABLE person_document 
  ( 
     person_person_id      VARCHAR(255) NOT NULL, 
     documents_document_id VARCHAR(255) NOT NULL, 
     primary key (person_person_id, documents_document_id) 
  ); 

CREATE TABLE userdetails 
  ( 
     userdetails_id     VARCHAR(255) NOT NULL, 
     account_enabled    BIT, 
     account_expired    BIT, 
     account_locked     BIT, 
     credential_expired BIT, 
     password           VARCHAR(255), 
     updt_dt_tm         TIMESTAMP NOT NULL, 
     updt_task          VARCHAR(255) NOT NULL, 
     updt_user          VARCHAR(255) NOT NULL, 
     username           VARCHAR(255), 
     primary key (userdetails_id), 
     UNIQUE (userdetails_id) 
  ); 

CREATE TABLE userdetails_personauthority 
  ( 
     userdetails_id     VARCHAR(255) NOT NULL, 
     personauthority_id VARCHAR(255) NOT NULL, 
     UNIQUE (personauthority_id) 
  ); 

--alter tables

alter table PERSON add constraint FK8C768F5562A11578 foreign key (DEMOGRAPHIC_ID_FK) references DEMOGRAPHIC;
alter table PERSON add constraint FK8C768F5533196B27 foreign key (USERDETAILS_ID_FK) references USERDETAILS;
alter table PERSON_DOCUMENT add constraint FKA244D2C572966ACF foreign key (documents_DOCUMENT_ID) references DOCUMENT;
alter table PERSON_DOCUMENT add constraint FKA244D2C58C64AA2C foreign key (person_PERSON_ID) references PERSON;
alter table USERDETAILS_PERSONAUTHORITY add constraint FKFA674F2688B1D55E foreign key (PERSONAUTHORITY_ID) references PERSONAUTHORITY;
alter table USERDETAILS_PERSONAUTHORITY add constraint FKFA674F2626C21929 foreign key (USERDETAILS_ID) references USERDETAILS;
