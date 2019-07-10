-- database: TESTDB
-- localhost, 1521

-- login as system
CREATE USER imadmin IDENTIFIED BY giantant100;
GRANT create session TO imadmin;
GRANT create table TO imadmin;
GRANT create view TO imadmin;
GRANT create any trigger TO imadmin;
GRANT create any procedure TO imadmin;
GRANT create sequence TO imadmin;
GRANT create synonym TO imadmin;  
alter user imadmin quota 128M on users;

CREATE USER imwriter IDENTIFIED BY giantant100;
GRANT create session TO imwriter;
GRANT create table TO imwriter;
GRANT create view TO imwriter;
GRANT create any trigger TO imwriter;
GRANT create any procedure TO imwriter;
GRANT create sequence TO imwriter;
GRANT create synonym TO imwriter;
ALTER USER imwriter QUOTA 100M ON USERS;

-- login as imadmin
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_TRANSACTION_SUMMARIES TO imwriter;
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_COMMAND_SUMMARIES TO imwriter;
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_SERVICE_REQUEST_SUMMARIES TO imwriter;
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_TRANSACTION TO imwriter;
GRANT SELECT ON imadmin.IM_SEQ TO imwriter;

-- login as imwriter
CREATE SYNONYM im_transaction_summaries FOR imadmin.IM_TRANSACTION_SUMMARIES;
CREATE SYNONYM im_command_summaries FOR imadmin.IM_COMMAND_SUMMARIES;
CREATE SYNONYM im_service_request_summaries FOR imadmin.IM_SERVICE_REQUEST_SUMMARIES;
CREATE SYNONYM im_transaction FOR imadmin.IM_TRANSACTION;
CREATE SYNONYM im_seq FOR imadmin.IM_SEQ;

-- test srquence as a imwriter
select im_seq.nextval from dual;

-- login as system
CREATE USER objtransfer IDENTIFIED BY giantant100;
GRANT create session TO objtransfer;
GRANT create table TO objtransfer;
GRANT create view TO objtransfer;
GRANT create any trigger TO objtransfer;
GRANT create any procedure TO objtransfer;
GRANT create sequence TO objtransfer;
GRANT create synonym TO objtransfer;
GRANT execute any procedure TO objtransfer;
alter user objtransfer quota 128M on users;

