package bs2.cim.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import bs2.cim.persistence.handler.ScratchPadTransferHandler;
import bs2.cim.persistence.handler.SmsTransferHandler;

/**
 * This component implements the CIM business logic.
 * 
 * @author Anton Nazarov
 * @since 31/07/2019
 */
@Component
public class CIMHandler {

    Logger logger = LoggerFactory.getLogger(CIMHandler.class);

    @Autowired
    ScratchPadTransferHandler scratchPadHandler;

    @Autowired
    SmsTransferHandler smsHandler;

    @Async
    public void handle(String subscriberSeq, String subId, String subIdType, String subscriberType, String spName,
            String interactionDate, String callId, String userName, String accountId, String source, String topicCode,
            String comment) {
        String params = "subscriberSeq=[" + subscriberSeq + "], subId=[" + subId + "], subIdType=[" + subIdType
                + "], subscriberType=[" + subscriberType + "], spName=[" + spName + "], interactionDate=["
                + interactionDate + "], callId=[" + callId + "], userName=[" + userName + "], accountId=[" + accountId
                + "], source=[" + source + "], topicCode=[" + topicCode + "], comment=[" + comment + "]";

        java.util.Date now = new java.util.Date();
        if (topicCode.startsWith("<") && topicCode.endsWith(">")) {
            logger.info("CustomerInteractionServiceController: calling insertSmsEntry() with the following parameters: "
                    + params);
            smsHandler.insertSmsEntry(subscriberSeq, subId, subIdType, subscriberType, spName, now, callId, userName,
                    accountId, source, topicCode, comment);
        } else {
            logger.info(
                    "CustomerInteractionServiceController: calling insertScratchPadEntry() with the following parameters: "
                            + params);
            scratchPadHandler.insertScratchPadEntry(subscriberSeq, subId, subIdType, subscriberType, spName, now,
                    callId, userName, accountId, source, topicCode, comment);
        }
    }
}
