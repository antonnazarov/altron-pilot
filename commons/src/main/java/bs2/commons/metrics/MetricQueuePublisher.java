package bs2.commons.metrics;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * The generic publisher into the Metric queue.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
@Component
public class MetricQueuePublisher {

    private static final Logger logger = LoggerFactory.getLogger(MetricQueuePublisher.class);

    private Source source;

    @Autowired
    public MetricQueuePublisher(Source source) {
        this.source = source;
    }

    public void publish(int periodInterval, java.util.Date periodDate, String serverName, String originId,
            String transactionClass, String transactionType, String transactionResult, long transactionDuration) {
        MetricRequest request = new MetricRequest(periodInterval, periodDate, serverName, originId, transactionClass,
                transactionType, transactionResult, transactionDuration, "1HOUR");
        source.output().send(MessageBuilder.withPayload(request).build());

        logger.info("the following payload has been published: " + request.toString());
    }

    public void publish(String serverName, String originId, String transactionClass, String transactionType,
            String transactionResult, long transactionDuration) {
        publish(LocalTime.now().getHour(), new java.util.Date(), serverName, originId, transactionClass,
                transactionType, transactionResult, transactionDuration);
    }
}
