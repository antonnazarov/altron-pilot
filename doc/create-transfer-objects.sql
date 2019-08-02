-- login as objtransfer
create table SMS_TRANSFER (
   ID                         NUMBER(19) not null,
   INTERACTION_DATE           TIMESTAMP not null,
   CALL_ID                    VARCHAR(20) not null,
   USER_NAME                  VARCHAR(50) not null,
   SUB_ID                     VARCHAR(30) not null,
   SUB_ID_TYPE                VARCHAR(15) not null,
   ACCOUNT_ID                 VARCHAR(50) not null,
   S_SOURCE                     VARCHAR(25) not null,
   TOPIC_CODE                 VARCHAR(35) not null,
   S_COMMENT                    VARCHAR(100) not null,
   SUBSCRIBER_SEQ             VARCHAR(20) not null,
   SUBSCRIBER_TYPE            VARCHAR(30) not null,
   SP_NAME                    VARCHAR(35) not null,
   constraint PK_SMS_TRANSFER primary key (ID)
);

create table SCRATCHPAD_TRANSFER (
   ID                         NUMBER(19) not null,
   INTERACTION_DATE           TIMESTAMP not null,
   CALL_ID                    VARCHAR(20) not null,
   USER_NAME                  VARCHAR(50) not null,
   SUB_ID                     VARCHAR(30) not null,
   SUB_ID_TYPE                VARCHAR(15) not null,
   ACCOUNT_ID                 VARCHAR(50) not null,
   S_SOURCE                     VARCHAR(25) not null,
   TOPIC_CODE                 VARCHAR(35) not null,
   S_COMMENT                    VARCHAR(100) not null,
   SUBSCRIBER_SEQ             VARCHAR(20) not null,
   SUBSCRIBER_TYPE            VARCHAR(30) not null,
   SP_NAME                    VARCHAR(35) not null,
   constraint PK_SCRATCHPAD_TRANSFER primary key (ID)
);

CREATE SEQUENCE  TRANSFER_SEQ  
   MINVALUE 1 MAXVALUE 9999999999999999999999999999 
   INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER
   NOCYCLE NOKEEP NOSCALE GLOBAL;

CREATE OR REPLACE PACKAGE MS_SMS_TRANSFER AS 
   PROCEDURE P_Insert_SMS(p_TimeStamp TIMESTAMP, p_Call_ID VARCHAR2, 
      p_Agent_Id VARCHAR2, p_subscriber_Id VARCHAR2, p_subscriber_Id_Type VARCHAR2, 
      p_account_ID VARCHAR2, p_Source VARCHAR2, p_Topic VARCHAR2, p_Detail VARCHAR2, 
      p_ICAP_ID VARCHAR2, p_SUB_TYPE VARCHAR2, p_SP_NAME VARCHAR2); 
END MS_SMS_TRANSFER; 
/

CREATE OR REPLACE PACKAGE BODY MS_SMS_TRANSFER AS 
   new_id NUMBER;
   
   PROCEDURE P_Insert_SMS(p_TimeStamp TIMESTAMP, p_Call_ID VARCHAR2, 
      p_Agent_Id VARCHAR2, p_subscriber_Id VARCHAR2, p_subscriber_Id_Type VARCHAR2, 
      p_account_ID VARCHAR2, p_Source VARCHAR2, p_Topic VARCHAR2, p_Detail VARCHAR2, 
      p_ICAP_ID VARCHAR2, p_SUB_TYPE VARCHAR2, p_SP_NAME VARCHAR2) IS
      
      BEGIN
         SELECT TRANSFER_SEQ.NEXTVAL INTO new_id FROM DUAL; 
         INSERT INTO SMS_TRANSFER VALUES (new_id, p_TimeStamp, p_Call_ID, p_Agent_Id,
            p_subscriber_Id, p_subscriber_Id_Type, p_account_ID, p_Source, p_Topic,
            p_Detail, p_ICAP_ID, p_SUB_TYPE, p_SP_NAME);
      END;
END MS_SMS_TRANSFER;
/

CREATE OR REPLACE PACKAGE SP_Scratchpad_Transfer AS 
   PROCEDURE P_Insert_Scratchpad(p_TimeStamp TIMESTAMP, p_Call_ID VARCHAR2, 
      p_Agent_Id VARCHAR2, p_subscriber_Id VARCHAR2, p_subscriber_Id_Type VARCHAR2, 
      p_account_ID VARCHAR2, p_Source VARCHAR2, p_Topic VARCHAR2, p_Detail VARCHAR2, 
      p_ICAP_ID VARCHAR2, p_SUB_TYPE VARCHAR2, p_SP_NAME VARCHAR2); 
END SP_Scratchpad_Transfer; 
/

CREATE OR REPLACE PACKAGE BODY SP_Scratchpad_Transfer AS 
   new_id NUMBER;
   
   PROCEDURE P_Insert_Scratchpad(p_TimeStamp TIMESTAMP, p_Call_ID VARCHAR2, 
      p_Agent_Id VARCHAR2, p_subscriber_Id VARCHAR2, p_subscriber_Id_Type VARCHAR2, 
      p_account_ID VARCHAR2, p_Source VARCHAR2, p_Topic VARCHAR2, p_Detail VARCHAR2, 
      p_ICAP_ID VARCHAR2, p_SUB_TYPE VARCHAR2, p_SP_NAME VARCHAR2) IS
      
      BEGIN
         SELECT TRANSFER_SEQ.NEXTVAL INTO new_id FROM DUAL; 
         INSERT INTO SCRATCHPAD_TRANSFER VALUES (new_id, p_TimeStamp, p_Call_ID, p_Agent_Id,
            p_subscriber_Id, p_subscriber_Id_Type, p_account_ID, p_Source, p_Topic,
            p_Detail, p_ICAP_ID, p_SUB_TYPE, p_SP_NAME);
      END;
END SP_Scratchpad_Transfer;
/
