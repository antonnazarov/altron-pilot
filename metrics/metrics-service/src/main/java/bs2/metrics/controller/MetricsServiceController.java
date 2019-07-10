package bs2.metrics.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bs2.metrics.handler.MetricTransactionHandler;

/**
 * The controller of the Metrics service. Allows to call the service in form:
 * http://localhost:8080/altron/metrics?periodInterval=14&periodDt=2019-07-09&serverName=Godzilla........
 * 
 * @author Anton Nazarov
 * @since 09/07/2019
 */
@RestController
public class MetricsServiceController {

    Logger logger = LoggerFactory.getLogger(MetricsServiceController.class);

    @Autowired
    MetricTransactionHandler transactionHandler;

    @RequestMapping(value = "altron/metrics", params = { "periodInterval", "periodDt", "serverName", "originId",
            "transactionClass", "transactionType", "periodType", "transactionResult",
            "transactionDuration" }, method = RequestMethod.GET)
    public String registerMetric(@RequestParam("periodInterval") int periodInterval,
            @RequestParam("periodDt") String periodDt, @RequestParam("serverName") String serverName,
            @RequestParam("originId") String originId, @RequestParam("transactionClass") String transactionClass,
            @RequestParam("transactionType") String transactionType, @RequestParam("periodType") String periodType,
            @RequestParam("transactionResult") String transactionResult,
            @RequestParam("transactionDuration") long transactionDuration) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date periodDate = null;
        try {
            periodDate = df.parse(periodDt);
        } catch (ParseException pe) {
            logger.error("Unable to parse the periodDt=[" + periodDt + "]");
            return "Error";
        }

        logger.info("periodInterval=[" + periodInterval + "], periodDt=[" + periodDt + "], serverName=[" + serverName
                + "], originId=[" + originId + "], transactionClass=[" + transactionClass + "], transactionType=["
                + transactionType + "], periodType=[" + periodType + "], transactionResult=[" + transactionResult
                + "], transactionDuration=[" + transactionDuration + "]");

        transactionHandler.saveMetricTransaction(periodInterval, periodDate, serverName, originId, transactionClass,
                transactionType, periodType, transactionResult, transactionDuration);

        return "ok";
    }
}
