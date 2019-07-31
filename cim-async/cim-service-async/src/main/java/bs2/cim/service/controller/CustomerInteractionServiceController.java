package bs2.cim.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bs2.commons.cim.CustomerInteractionService;

@RestController
public class CustomerInteractionServiceController implements CustomerInteractionService {

    @Autowired
    CIMHandler cimHandler;

    @Override
    public String storeCustomerInteraction(String subscriberSeq, String subId, String subIdType, String subscriberType,
            String spName, String interactionDate, String callId, String userName, String accountId, String source,
            String topicCode, String comment) {
        cimHandler.handle(subscriberSeq, subId, subIdType, subscriberType, spName, interactionDate, callId, userName,
                accountId, source, topicCode, comment);

        return "ok";
    }
}
