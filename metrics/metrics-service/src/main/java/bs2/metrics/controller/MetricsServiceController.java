package bs2.metrics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller of the Metrics service. Allows to call the service in form:
 * http://localhost:8080/altron/metrics?periodInterval=14&periodDt=2019-07-09&serverName=Godzilla........
 * 
 * @author Anton Nazarov
 * @since 09/07/2019
 */
@RestController
public class MetricsServiceController {

    @RequestMapping(value = "altron/metrics", params = { "periodInterval", "periodDt", "serverName", "originId",
            "transactionClass", "transactionType", "periodType", "transactionResult",
            "transactionDuration" }, method = RequestMethod.GET)
    public String registerMetric(@RequestParam("periodInterval") String periodInterval,
            @RequestParam("periodDt") String periodDt, @RequestParam("serverName") String serverName,
            @RequestParam("originId") String originId, @RequestParam("transactionClass") String transactionClass,
            @RequestParam("transactionType") String transactionType, @RequestParam("periodType") String periodType,
            @RequestParam("transactionResult") String transactionResult,
            @RequestParam("transactionDuration") long transactionDuration) {

        System.out.println("periodInterval=[" + periodInterval + "], periodDt=[" + periodDt + "], serverName=["
                + serverName + "], originId=[" + originId + "], transactionClass=[" + transactionClass
                + "], transactionType=[" + transactionType + "], periodType=[" + periodType + "], transactionResult=["
                + transactionResult + "], transactionDuration=[" + transactionDuration + "]");

        return "ok";
    }
}
