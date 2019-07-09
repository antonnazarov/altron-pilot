-- login as imadmin

-- ****************************************************
-- *             IM_TRANSACTION_SUMMARIES             *
-- ****************************************************
create table IM_TRANSACTION (
   ID                         NUMBER(19) not null,
   CREATED_DT                 TIMESTAMP not null,
   PERIOD_INTERVAL            NUMBER(10) not null,
   PERIOD_DT                  DATE not null,
   SERVER_NAME                VARCHAR2(20) not null,
   ORIGIN_ID                  VARCHAR2(20) not null,
   TRANSACTION_CLASS          VARCHAR2(30) not null,
   TRANSACTION_TYPE           VARCHAR2(30) not null,
   PERIOD_TYPE                VARCHAR2(10) not null,
   TRANSACTION_RESULT         VARCHAR2(10) not null, -- SUCESS, EXCEPTION
   TRANSACTION_DURATION       NUMBER(9) not null,
   RECORD_STATUS              VARCHAR2(10) not null, -- NEW, PROCESSING, PROCESSED
   constraint PK_IM_TRANSACTION primary key (ID)
);
