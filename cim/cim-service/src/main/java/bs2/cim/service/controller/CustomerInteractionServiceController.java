package bs2.cim.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bs2.cim.persistence.handler.ScratchPadHandler;
import bs2.commons.cim.CustomerInteractionService;

@RestController
public class CustomerInteractionServiceController implements CustomerInteractionService {

    @Autowired
    ScratchPadHandler scratchPadHandler;

    @Override
    public void storeScratchPadEntry(String subscriberSeq, String subId, String subIdType, String subscriberType,
            String spName, String interactionDate, String callId, String userName, String accountId, String source,
            String topicCode, String comment) {
        
        scratchPadHandler.storeScratchPadEntry(subscriberSeq, subId, subIdType, subscriberType, spName, interactionDate,
                callId, userName, accountId, source, topicCode, comment);
    }
}
