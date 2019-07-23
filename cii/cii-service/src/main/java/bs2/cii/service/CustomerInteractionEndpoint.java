package bs2.cii.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bs2.cii.service.gen.AddCIMInteractionRequest;
import bs2.cii.service.gen.AddCIMInteractionResponse;
import bs2.cii.service.gen.InteractionRequest;
import bs2.commons.cim.CustomerInteractionService;
import bs2.commons.metrics.Metricable;

@Endpoint
public class CustomerInteractionEndpoint {

    private static final String NAMESPACE_URI = "http://localhost/ci/interface";
    Logger logger = LoggerFactory.getLogger(CustomerInteractionEndpoint.class);

    @Autowired
    CustomerInteractionService cis;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCIMInteractionRequest")
    @ResponsePayload
    @Metricable(serverName = "CII::addRequest", transactionType = "ADCMDN")
    public AddCIMInteractionResponse addCIMInteractionRequest(@RequestPayload AddCIMInteractionRequest request) {
        AddCIMInteractionResponse response = new AddCIMInteractionResponse();
        InteractionRequest req = request.getInteractionRequest();

        logger.info("CustomerInteractionService: " + cis);

        try {
            cis.storeCustomerInteraction("test_seq", "test_sub", "test_sub_type", "sub_type", "test_sp_name",
                    "2019-07-23", String.valueOf(req.getCallId()), "test_user", req.getAccountId(), req.getSource(),
                    req.getTopicCode(), req.getComment());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        logger.info("addCIMInteractionRequest... has been called");

        response.setInteractionResponse("OK");

        return response;
    }
}
