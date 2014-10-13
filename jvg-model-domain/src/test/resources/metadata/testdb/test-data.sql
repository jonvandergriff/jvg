INSERT INTO demographic 
  ( 
	 demographic_id, 
     beg_eff_dt_tm, 
     create_dt_tm, 
     end_eff_dt_tm, 
     name, 
     updt_dt_tm, 
     updt_task, 
     updt_user
  ) 
  values
  (
	'DEMOGRAPHIC-1234567890',
	CURRENT_TIMESTAMP,
	CURRENT_TIMESTAMP,
	CURRENT_TIMESTAMP,
	'Walter White',
	CURRENT_TIMESTAMP,
	'Test Data',
	'HSQLDB'
  ); 
  
INSERT INTO personauthority 
  ( 
     personauthority_id, 
     authority, 
     beg_eff_dt_tm, 
     create_dt_tm, 
     end_eff_dt_tm, 
     updt_dt_tm, 
     updt_task, 
     updt_user
  ) 
  values
  (
  	'PERSONAUTHORITY-1234567890',
  	'ROLE_ADMIN',
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
	'Test Data',
	'HSQLDB'
  );   
  
INSERT INTO userdetails 
  ( 
     userdetails_id, 
     account_enabled, 
     account_expired, 
     account_locked, 
     beg_eff_dt_tm, 
     create_dt_tm, 
     credential_expired, 
     end_eff_dt_tm, 
     password, 
     updt_dt_tm, 
     updt_task, 
     updt_user,
     username
  )
  values
  (
  	'USERDETAILS-1234567890',
  	1,
  	0,
  	0,
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
  	0,
  	CURRENT_TIMESTAMP,
  	'cerner1',
  	CURRENT_TIMESTAMP,
	'Test Data',
	'HSQLDB',
	'admin'
  );  

INSERT INTO person 
  ( 
     person_id, 
     beg_eff_dt_tm, 
     create_dt_tm, 
     end_eff_dt_tm, 
     updt_dt_tm, 
     updt_task, 
     updt_user, 
     demographic_id_fk, 
     userdetails_id_fk
  ) 
  values
  (
  	'PERSON-1234567890',
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
  	CURRENT_TIMESTAMP,
	'Test Data',
	'HSQLDB',
	'DEMOGRAPHIC-1234567890',
	'USERDETAILS-1234567890'
  );
  
INSERT INTO userdetails_personauthority 
  ( 
     userdetails_id, 
     personauthority_id 
  )
  values
  (
  	'USERDETAILS-1234567890',
  	'PERSONAUTHORITY-1234567890'
  ); 
