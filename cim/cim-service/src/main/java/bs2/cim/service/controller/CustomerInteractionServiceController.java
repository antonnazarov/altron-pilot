package bs2.cim.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bs2.cim.persistence.handler.ScratchPadTransferHandler;
import bs2.cim.persistence.handler.SmsTransferHandler;
import bs2.commons.cim.CustomerInteractionService;

@RestController
public class CustomerInteractionServiceController implements CustomerInteractionService {

    Logger logger = LoggerFactory.getLogger(CustomerInteractionServiceController.class);

    @Autowired
    ScratchPadTransferHandler scratchPadHandler;

    @Autowired
    SmsTransferHandler smsHandler;

    @Override
    public String storeCustomerInteraction(String subscriberSeq, String subId, String subIdType, String subscriberType,
            String spName, String interactionDate, String callId, String userName, String accountId, String source,
            String topicCode, String comment) {

        java.util.Date now = new java.util.Date();
        if (topicCode.startsWith("<") && topicCode.endsWith(">")) {
            logger.info(
                    "CustomerInteractionServiceController: calling insertSmsEntry() with the following parameters: subscriberSeq=["
                            + subscriberSeq + "], subId=[" + subId + "], subIdType=[" + subIdType
                            + "], subscriberType=[" + subscriberType + "], spName=[" + spName + "], interactionDate=["
                            + interactionDate + "], callId=[" + callId + "], userName=[" + userName + "], accountId=["
                            + accountId + "], source=[" + source + "], topicCode=[" + topicCode + "], comment=["
                            + comment + "]");
            smsHandler.insertSmsEntry(subscriberSeq, subId, subIdType, subscriberType, spName, now, callId, userName,
                    accountId, source, topicCode, comment);
        } else {
            logger.info(
                    "CustomerInteractionServiceController: calling insertScratchPadEntry() with the following parameters: subscriberSeq=["
                            + subscriberSeq + "], subId=[" + subId + "], subIdType=[" + subIdType
                            + "], subscriberType=[" + subscriberType + "], spName=[" + spName + "], interactionDate=["
                            + interactionDate + "], callId=[" + callId + "], userName=[" + userName + "], accountId=["
                            + accountId + "], source=[" + source + "], topicCode=[" + topicCode + "], comment=["
                            + comment + "]");
            scratchPadHandler.insertScratchPadEntry(subscriberSeq, subId, subIdType, subscriberType, spName, now,
                    callId, userName, accountId, source, topicCode, comment);
        }

        return "ok";
    }
}
