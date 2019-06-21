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

CREATE USER imwriter IDENTIFIED BY giantant100;
GRANT create session TO imwriter;
GRANT create table TO imwriter;
GRANT create view TO imwriter;
GRANT create any trigger TO imwriter;
GRANT create any procedure TO imwriter;
GRANT create sequence TO imwriter;
GRANT create synonym TO imwriter;

-- login as imadmin
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_TRANSACTION_SUMMARIES TO imwriter;
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_COMMAND_SUMMARIES TO imwriter;
GRANT SELECT, INSERT, UPDATE, DELETE ON imadmin.IM_SERVICE_REQUEST_SUMMARIES TO imwriter;

-- login as imwriter
CREATE SYNONYM im_transaction_summaries FOR imadmin.IM_TRANSACTION_SUMMARIES;
CREATE SYNONYM im_command_summaries FOR imadmin.IM_COMMAND_SUMMARIES;
CREATE SYNONYM im_service_request_summaries FOR imadmin.IM_SERVICE_REQUEST_SUMMARIES;

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

-- {call MS_SMS_TRANSFER.P_Insert_SMS(?,?,?,?,?,?,?,?,?,?,?,? ) }
-- {call SP_Scratchpad_Transfer.P_Insert_Scratchpad(?,?,?,?,?,?,?,?,?,?,?,? ) }
