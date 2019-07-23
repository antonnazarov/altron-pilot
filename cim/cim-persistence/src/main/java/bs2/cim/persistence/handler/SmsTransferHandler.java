package bs2.cim.persistence.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

/**
 * The sms- transfer handler.
 * 
 * @author Anton Nazarov
 * @since 23/07/2019
 */
@Component
public class SmsTransferHandler {

    @Autowired
    JdbcOperations operations;

    public void insertSmsEntry(String subscriberSeq, String subId, String subIdType, String subscriberType,
            String spName, java.util.Date interactionDate, String callId, String userName, String accountId, String source,
            String topicCode, String comment) {
        operations.update("{ call MS_SMS_TRANSFER.P_Insert_SMS(?,?,?,?,?,?,?,?,?,?,?,?) }", interactionDate, callId,
                userName, subId, subIdType, accountId, source, topicCode, comment, subscriberSeq, subscriberType,
                spName);
    }
}
