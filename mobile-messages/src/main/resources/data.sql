insert into USERS VALUES (1, 'jcrada', 'Juan Camilo Rada');
insert into USERS VALUES (2, 'lgonzales', 'Luz Gonzalez');

insert into CONTACTS VALUES (1, 2);
insert into CONTACTS VALUES (2, 1);

insert into MESSAGES (MESSAGE_ID, USER_FROM, USER_TO, MESSAGE_TEXT, M_DATE) VALUES (1, 1, 2, 'Hola Luz', now());
insert into MESSAGES (MESSAGE_ID, USER_FROM, USER_TO, MESSAGE_TEXT, M_DATE) VALUES (2, 2, 1, 'Hola Juan', now());