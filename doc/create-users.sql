CREATE USER imadmin IDENTIFIED BY password;
GRANT create session TO imadmin;
GRANT create table TO imadmin;
GRANT create view TO imadmin;
GRANT create any trigger TO imadmin;
GRANT create any procedure TO imadmin;
GRANT create sequence TO imadmin;
GRANT create synonym TO imadmin;  
alter user imadmin quota 128M on users;
alter user imadmin quota 128M on system;


CREATE USER imwriter IDENTIFIED BY password;
GRANT create session TO imwriter;
GRANT create table TO imwriter;
GRANT create view TO imwriter;
GRANT create any trigger TO imwriter;
GRANT create any procedure TO imwriter;
GRANT create sequence TO imwriter;
GRANT create synonym TO imwriter;
ALTER USER imwriter QUOTA 100M ON USERS;
alter user imwriter quota 128M on system;

CREATE USER objtransfer IDENTIFIED BY password;
GRANT create session TO objtransfer;
GRANT create table TO objtransfer;
GRANT create view TO objtransfer;
GRANT create any trigger TO objtransfer;
GRANT create any procedure TO objtransfer;
GRANT create sequence TO objtransfer;
GRANT create synonym TO objtransfer;
GRANT execute any procedure TO objtransfer;
alter user objtransfer quota 128M on users;
alter user objtransfer quota 128M on system;
