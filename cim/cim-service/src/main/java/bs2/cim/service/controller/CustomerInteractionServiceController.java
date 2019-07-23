package bs2.cim.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "altron/cim", params = { "subscriberSeq", "subId", "subIdType", "subscriberType",
            "spName", "interactionDate", "callId", "userName",
            "accountId", "source", "topicCode", "comment" }, method = RequestMethod.GET)
    public String storeCustomerInteraction(@RequestParam("subscriberSeq") String subscriberSeq, 
            @RequestParam("subId") String subId, @RequestParam("subIdType") String subIdType, @RequestParam("subscriberType") String subscriberType,
            @RequestParam("spName") String spName, @RequestParam("interactionDate") String interactionDate, @RequestParam("callId")String callId, 
            @RequestParam("userName") String userName, @RequestParam("accountId") String accountId, @RequestParam("source") String source,
            @RequestParam("topicCode") String topicCode, @RequestParam("comment") String comment) {

        java.util.Date now = new java.util.Date();
        if (topicCode.startsWith("<") && topicCode.endsWith(">")) {
            logger.info(
                    "CustomerInteractionServiceController: calling insertSmsEntry() with the following parameters: subscriberSeq=["
                            + subscriberSeq + "], subId=[" + subId + "], subIdType=[" + subIdType
                            + "], subscriberType=[" + subscriberType + "], spName=[" + spName + "], interactionDate=["
                            + interactionDate + "], callId=[" + callId + "], userName=[" + userName + "], accountId=["
                            + accountId + "], source=[" + source + "], topicCode=[" + topicCode + "], comment=["
                            + comment + "]");
            smsHandler.insertSmsEntry(subscriberSeq, subId, subIdType, subscriberType, spName, now, callId,
                    userName, accountId, source, topicCode, comment);
        } else {
            logger.info(
                    "CustomerInteractionServiceController: calling insertScratchPadEntry() with the following parameters: subscriberSeq=["
                            + subscriberSeq + "], subId=[" + subId + "], subIdType=[" + subIdType
                            + "], subscriberType=[" + subscriberType + "], spName=[" + spName + "], interactionDate=["
                            + interactionDate + "], callId=[" + callId + "], userName=[" + userName + "], accountId=["
                            + accountId + "], source=[" + source + "], topicCode=[" + topicCode + "], comment=["
                            + comment + "]");
            scratchPadHandler.insertScratchPadEntry(subscriberSeq, subId, subIdType, subscriberType, spName,
                    now, callId, userName, accountId, source, topicCode, comment);
        }
        
        return "ok";
    }
}
