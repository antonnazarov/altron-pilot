package altron.test.synch.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cim")
public interface CustomerInteractionService {

    @RequestMapping(value = "altron/cim", params = { "subscriberSeq", "subId", "subIdType", "subscriberType", "spName",
            "interactionDate", "callId", "userName", "accountId", "source", "topicCode",
            "comment" }, method = RequestMethod.GET)
    public String storeCustomerInteraction(@RequestParam("subscriberSeq") String subscriberSeq,
            @RequestParam("subId") String subId, @RequestParam("subIdType") String subIdType,
            @RequestParam("subscriberType") String subscriberType, @RequestParam("spName") String spName,
            @RequestParam("interactionDate") String interactionDate, @RequestParam("callId") String callId,
            @RequestParam("userName") String userName, @RequestParam("accountId") String accountId,
            @RequestParam("source") String source, @RequestParam("topicCode") String topicCode,
            @RequestParam("comment") String comment);
}
