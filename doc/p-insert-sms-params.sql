DECLARE
  P_TIMESTAMP TIMESTAMP;
  P_CALL_ID VARCHAR2(200);
  P_AGENT_ID VARCHAR2(200);
  P_SUBSCRIBER_ID VARCHAR2(200);
  P_SUBSCRIBER_ID_TYPE VARCHAR2(200);
  P_ACCOUNT_ID VARCHAR2(200);
  P_SOURCE VARCHAR2(200);
  P_TOPIC VARCHAR2(200);
  P_DETAIL VARCHAR2(200);
  P_ICAP_ID VARCHAR2(200);
  P_SUB_TYPE VARCHAR2(200);
  P_SP_NAME VARCHAR2(200);
BEGIN
  P_TIMESTAMP := SYSDATE;
  P_CALL_ID := 'C_221';
  P_AGENT_ID := 'AGENT-daa100';
  P_SUBSCRIBER_ID := 'sub500';
  P_SUBSCRIBER_ID_TYPE := 'unknown';
  P_ACCOUNT_ID := '7876164';
  P_SOURCE := 'SRC-200';
  P_TOPIC := 'topic-nnn';
  P_DETAIL := 'dtl-20190';
  P_ICAP_ID := 'i-cap-id';
  P_SUB_TYPE := 'normal';
  P_SP_NAME := 'extended';

  MS_SMS_TRANSFER.P_INSERT_SMS(
    P_TIMESTAMP => P_TIMESTAMP,
    P_CALL_ID => P_CALL_ID,
    P_AGENT_ID => P_AGENT_ID,
    P_SUBSCRIBER_ID => P_SUBSCRIBER_ID,
    P_SUBSCRIBER_ID_TYPE => P_SUBSCRIBER_ID_TYPE,
    P_ACCOUNT_ID => P_ACCOUNT_ID,
    P_SOURCE => P_SOURCE,
    P_TOPIC => P_TOPIC,
    P_DETAIL => P_DETAIL,
    P_ICAP_ID => P_ICAP_ID,
    P_SUB_TYPE => P_SUB_TYPE,
    P_SP_NAME => P_SP_NAME
  );
--rollback; 
END;