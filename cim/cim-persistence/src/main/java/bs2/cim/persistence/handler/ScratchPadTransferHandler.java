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
public class ScratchPadTransferHandler {

    @Autowired
    JdbcOperations operations;

    public void insertScratchPadEntry(String subscriberSeq, String subId, String subIdType, String subscriberType,
            String spName, java.util.Date interactionDate, String callId, String userName, String accountId, String source,
            String topicCode, String comment) {
        operations.update("{ call SP_Scratchpad_Transfer.P_Insert_Scratchpad(?,?,?,?,?,?,?,?,?,?,?,?) } ",
                interactionDate, callId, userName, subId, subIdType, accountId, source, topicCode, comment,
                subscriberSeq, subscriberType, spName);
    }
}
