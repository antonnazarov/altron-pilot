package bs2.cii.service;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bs2.cii.service.gen.AddCIMInteractionRequest;
import bs2.cii.service.gen.AddCIMInteractionResponse;
import bs2.commons.metrics.Metricable;

@Endpoint
public class CustomerInteractionEndpoint {

    private static final String NAMESPACE_URI = "http://localhost/ci/interface";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCIMInteractionRequest")
    @ResponsePayload
    @Metricable(serverName = "CustomerInteractionEndpoint::addCIMInteractionRequest", transactionType = "ADCMDN")
    public AddCIMInteractionResponse addCIMInteractionRequest(@RequestPayload AddCIMInteractionRequest request) {
        AddCIMInteractionResponse response = new AddCIMInteractionResponse();

        System.out.println("addCIMInteractionRequest...");
        response.setInteractionResponse("OK");

        return response;
    }
}
