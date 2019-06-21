-- login as imadmin

-- ****************************************************
-- *             IM_TRANSACTION_SUMMARIES             *
-- ****************************************************
create table IM_TRANSACTION_SUMMARIES (
   ID                         NUMBER(19) not null,
   MODIFIED_DT                DATE not null,
   PERIOD_INTERVAL            NUMBER(10) not null,
   PERIOD_DT                  DATE not null,
   SERVER_NAME                VARCHAR2(20) not null,
   ORIGIN_ID                  VARCHAR2(20) not null,
   TRANSACTION_CLASS          VARCHAR2(30) not null,
   TRANSACTION_TYPE           VARCHAR2(30) not null,
   PERIOD_TYPE                VARCHAR2(10) not null,
   TRANSACTION_COUNT          NUMBER(9) not null,
   TRANSACTION_DURATION_TOTAL NUMBER(9) not null,
   TRANSACTION_DURATION_MAX   NUMBER(9) not null,
   TRANSACTION_DURATION_MIN   NUMBER(9) not null,
   EXCEPTION_COUNT            NUMBER(9) not null,
   constraint PK_IM_TRANSACTION_SUMMARIES primary key (ID)
);


-- ****************************************************
-- *               IM_COMMAND_SUMMARIES               *
-- ****************************************************
create table IM_COMMAND_SUMMARIES (
   ID                     NUMBER(19) not null,
   MODIFIED_DATE          DATE not null,
   PERIOD_INTERVAL        NUMBER(9) not null,
   PERIOD_DATE            DATE not null,
   NE_ID                  VARCHAR2(20) not null,
   NE_STREAM              VARCHAR2(20) not null,
   PERIOD_TYPE            VARCHAR2(10) not null,
   SUCCESS_COUNT          NUMBER(9) not null,
   SUCCESS_DURATION_TOTAL NUMBER(9) not null,
   SUCCESS_DURATION_MAX   NUMBER(9) not null,
   SUCCESS_DURATION_MIN   NUMBER(9) not null,
   FAILED_COUNT           NUMBER(9) not null,
   FAILED_DURATION_TOTAL  NUMBER(9) not null,
   FAILED_DURATION_MAX    NUMBER(9) not null,
   FAILED_DURATION_MIN    NUMBER(9) not null,
   constraint PK_IM_COMMAND_SUMMARIES primary key (ID)
);


-- ****************************************************
-- *           IM_SERVICE_REQUEST_SUMMARIES           *
-- ****************************************************
create table IM_SERVICE_REQUEST_SUMMARIES (
   ID                    NUMBER(19) not null,
   MODIFIED_DATE         DATE not null,
   PERIOD_INTERVAL       NUMBER(10) not null,
   PERIOD_DATE           DATE not null,
   ORIGIN_ID             VARCHAR2(20) not null,
   REQUEST_TYPE          VARCHAR2(20) not null,
   PERIOD_TYPE           VARCHAR2(20) not null,
   SYNCHTHRU_COUNT       NUMBER(9) not null,
   SYNCHRONOUS_COUNT     NUMBER(9) not null,
   SYNCH_DURATION_TOTAL  NUMBER(9) not null,
   SYNCH_DURATION_MAX    NUMBER(9) not null,
   SYNCH_DURATION_MIN    NUMBER(9) not null,
   ASYNCH_CONFIG_COUNT   NUMBER(9) not null,
   ASYNCH_DEP_COUNT      NUMBER(9) not null,
   ASYNCH_PROV_COUNT     NUMBER(9) not null,
   ASYNCH_PENDING_COUNT  NUMBER(9) not null,
   ASYNCH_DURATION_TOTAL NUMBER(9) not null,
   ASYNCH_DURATION_MAX   NUMBER(9) not null,
   ASYNCH_DURATION_MIN   NUMBER(9) not null,
   EXCEPTIONS_COUNT      NUMBER(9) not null,
   constraint PK_IM_SERVICE_REQUEST_SUMMARIES primary key (ID)
);




--------------------------------------------------------
--  DDL for Sequence IM_SEQ
--------------------------------------------------------
CREATE SEQUENCE  IM_SEQ  
   MINVALUE 1 MAXVALUE 9999999999999999999999999999 
   INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER
   NOCYCLE NOKEEP NOSCALE GLOBAL;
