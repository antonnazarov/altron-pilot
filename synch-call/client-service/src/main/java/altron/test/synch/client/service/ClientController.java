package altron.test.synch.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ServiceProvider serviceProvider;

    @Autowired
    CustomerInteractionService cim;

    @RequestMapping(value = "altron/client", params = { "clientId" }, method = RequestMethod.GET)
    public String callClientSide(@RequestParam("clientId") String clientId) {
        logger.info("The Client Service was called with clientId=[" + clientId + "]");

        String ret = serviceProvider.handle(clientId);

        return ret;
    }

    @RequestMapping(value = "altron/cim", params = { "clientId" }, method = RequestMethod.GET)
    public String callCimService(@RequestParam("clientId") String clientId) {
        logger.info("callCimService() was called with clientId=[" + clientId + "]");

        cim.storeCustomerInteraction("subscriberSeq", "subId", "subIdType", "subscriberType", "spName",
                "interactionDate", "callId", "userName", "accountId", "source", "topicCode", "comment");

        return "CIM service was called with clientId=[" + clientId + "]";
    }
}
