drop table DEMOGRAPHIC if exists cascade;
drop table DOCUMENT if exists  cascade;
drop table PERSON if exists  cascade;
drop table LOCATIONDEFINITION if exists cascade;
drop table PERSONAUTHORITY if exists  cascade;
drop table PERSON_DOCUMENT if exists  cascade;
drop table USERDETAILS if exists  cascade;
drop table USERDETAILS_PERSONAUTHORITY if exists cascade;
drop table PATIENTDATA if exists cascade;
drop table PATIENT_PATIENTDATA if exists cascade;
drop table PATIENT if exists cascade;


CREATE TABLE demographic 
  ( 
     demographic_id VARCHAR(255) NOT NULL, 
     beg_eff_dt_tm  TIMESTAMP, 
     create_dt_tm   TIMESTAMP, 
     end_eff_dt_tm  TIMESTAMP, 
     NAME           VARCHAR(255), 
     updt_dt_tm     TIMESTAMP, 
     updt_task      VARCHAR(255) NOT NULL, 
     updt_user      VARCHAR(255) NOT NULL, 
     primary key (demographic_id), 
     UNIQUE (demographic_id) 
  ); 

CREATE TABLE document 
  ( 
     document_id   VARCHAR(255) NOT NULL, 
     beg_eff_dt_tm TIMESTAMP, 
     content       LONGVARCHAR, 
     create_dt_tm  TIMESTAMP NOT NULL, 
     end_eff_dt_tm TIMESTAMP, 
     updt_dt_tm    TIMESTAMP NOT NULL, 
     updt_task     VARCHAR(255) NOT NULL, 
     updt_user     VARCHAR(255) NOT NULL, 
     primary key (document_id), 
     UNIQUE (document_id) 
  ); 

CREATE TABLE person 
  ( 
     person_id         VARCHAR(255) NOT NULL, 
     beg_eff_dt_tm     TIMESTAMP, 
     create_dt_tm      TIMESTAMP NOT NULL, 
     end_eff_dt_tm     TIMESTAMP, 
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
     beg_eff_dt_tm      TIMESTAMP, 
     create_dt_tm       TIMESTAMP NOT NULL, 
     end_eff_dt_tm      TIMESTAMP, 
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
     account_enabled    BIT NOT NULL, 
     account_expired    BIT NOT NULL, 
     account_locked     BIT NOT NULL, 
     beg_eff_dt_tm      TIMESTAMP, 
     create_dt_tm       TIMESTAMP NOT NULL, 
     credential_expired BIT NOT NULL, 
     end_eff_dt_tm      TIMESTAMP, 
     password           VARCHAR(255) NOT NULL, 
     updt_dt_tm         TIMESTAMP NOT NULL, 
     updt_task          VARCHAR(255) NOT NULL, 
     updt_user          VARCHAR(255) NOT NULL, 
     username           VARCHAR(255) NOT NULL, 
     primary key (userdetails_id), 
     UNIQUE (userdetails_id) 
  ); 

CREATE TABLE userdetails_personauthority 
  ( 
     userdetails_id     VARCHAR(255) NOT NULL, 
     personauthority_id VARCHAR(255) NOT NULL, 
     UNIQUE (personauthority_id) 
  ); 
  
create table PATIENT 
	(
	PATIENT_ID varchar(255) not null, 
	EXTERNAL_ID varchar(255), 
	updt_dt_tm         TIMESTAMP NOT NULL, 
    updt_task          VARCHAR(255) NOT NULL, 
    updt_user          VARCHAR(255) NOT NULL, 
    beg_eff_dt_tm      TIMESTAMP, 
    create_dt_tm       TIMESTAMP NOT NULL, 
    end_eff_dt_tm      TIMESTAMP, 
	primary key (PATIENT_ID), unique (PATIENT_ID)
	);
	
create table PATIENTDATA 
	(
	PATIENTDATA_ID varchar(255) not null, 
	DATA longvarchar, 
	patient_PATIENT_ID varchar(255),
	updt_dt_tm         TIMESTAMP NOT NULL, 
    updt_task          VARCHAR(255) NOT NULL, 
    updt_user          VARCHAR(255) NOT NULL, 
    beg_eff_dt_tm      TIMESTAMP, 
    create_dt_tm       TIMESTAMP NOT NULL, 
    end_eff_dt_tm      TIMESTAMP, 
	primary key (PATIENTDATA_ID), unique (PATIENTDATA_ID)
	);
	
create table PATIENT_PATIENTDATA 
	(
	PATIENT_PATIENT_ID varchar(255) not null, 
	patientDatas_PATIENTDATA_ID varchar(255) not null, 
	unique (patientDatas_PATIENTDATA_ID)
	);

create table LOCATIONDEFINITION 
	(
	LOCATIONDEFINITION_ID varchar(255) not null, 
	LATITUDE_DEG double, 
	LATITUDE_RAD double, 
	LONGITUDE_DEG double, 
	LONGITUDE_RAD double, 
	ZIPCODE integer, 
	updt_dt_tm         TIMESTAMP NOT NULL, 
    updt_task          VARCHAR(255) NOT NULL, 
    updt_user          VARCHAR(255) NOT NULL, 
    beg_eff_dt_tm      TIMESTAMP, 
    create_dt_tm       TIMESTAMP NOT NULL, 
    end_eff_dt_tm      TIMESTAMP, 
	primary key (LOCATIONDEFINITION_ID), unique (LOCATIONDEFINITION_ID)
	);

ALTER TABLE person ADD constraint fk8c768f5562a11578 foreign key ( 
demographic_id_fk) references demographic; 

ALTER TABLE person ADD constraint fk8c768f5533196b27 foreign key ( 
userdetails_id_fk) references userdetails; 

ALTER TABLE person_document ADD constraint fka244d2c572966acf foreign key ( 
documents_document_id) references document; 

ALTER TABLE person_document ADD constraint fka244d2c58c64aa2c foreign key ( 
person_person_id) references person; 

ALTER TABLE userdetails_personauthority ADD constraint fkfa674f2688b1d55e 
foreign key (personauthority_id) references personauthority; 

ALTER TABLE userdetails_personauthority ADD constraint fkfa674f2626c21929 
foreign key (userdetails_id) references userdetails;

alter table PATIENTDATA add constraint FK9FAF640F9059F798 foreign key (patient_PATIENT_ID) references PATIENT;
alter table PATIENT_PATIENTDATA add constraint FKBFEF09B52D0C6779 foreign key (patientDatas_PATIENTDATA_ID) references PATIENTDATA;
alter table PATIENT_PATIENTDATA add constraint FKBFEF09B59059F798 foreign key (PATIENT_PATIENT_ID) references PATIENT;