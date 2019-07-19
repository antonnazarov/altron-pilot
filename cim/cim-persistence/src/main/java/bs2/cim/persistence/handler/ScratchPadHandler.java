package bs2.cim.persistence.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

/**
 * The ScratchPad handler implementation.
 * 
 * @author Anton Nazarov
 * @since 19/07/2019
 */
@Component
public class ScratchPadHandler {

    @Autowired
    JdbcOperations operations;

    public void storeScratchPadEntry(String subscriberSeq, String subId, String subIdType, String subscriberType,
            String spName, String interactionDate, String callId, String userName, String accountId, String source,
            String topicCode, String comment) {
        if (topicCode.startsWith("<") && topicCode.endsWith(">")) {
            operations.update("{ call MS_SMS_TRANSFER.P_Insert_SMS(?,?,?,?,?,?,?,?,?,?,?,?) }", interactionDate, callId,
                    userName, subId, subIdType, accountId, source, topicCode, comment, subscriberSeq, subscriberType,
                    spName);
        } else {
            operations.update("{ call SP_Scratchpad_Transfer.P_Insert_Scratchpad(?,?,?,?,?,?,?,?,?,?,?,?) } ",
                    interactionDate, callId, userName, subId, subIdType, accountId, source, topicCode, comment,
                    subscriberSeq, subscriberType, spName);
        }
    }
}
