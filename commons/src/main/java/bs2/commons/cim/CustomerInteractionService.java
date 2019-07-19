package bs2.commons.cim;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-cloud-eureka-client")
public interface CustomerInteractionService {

    @RequestMapping(value = "altron/cim/scratchpadhandler", params = { "subscriberSeq", "subId", "subIdType",
            "subscriberType", "spName", "interactionDate", "callId", "userName", "accountId", "source", "topicCode",
            "comment" }, method = RequestMethod.GET)
    public void storeScratchPadEntry(@RequestParam("subscriberSeq") String subscriberSeq,
            @RequestParam("subId") String subId, @RequestParam("subIdType") String subIdType,
            @RequestParam("subscriberType") String subscriberType, @RequestParam("spName") String spName,
            @RequestParam("interactionDate") String interactionDate, @RequestParam("callId") String callId,
            @RequestParam("userName") String userName, @RequestParam("accountId") String accountId,
            @RequestParam("source") String source, @RequestParam("source") String topicCode,
            @RequestParam("source") String comment);
}
