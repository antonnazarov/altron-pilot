package bs2.metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import bs2.commons.metrics.MetricRequest;
import bs2.metrics.handler.MetricTransactionHandler;

/**
 * The metric service runner application.
 * 
 * @author Anton Nazarov
 * @since 09/07/2019
 */

@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    MetricTransactionHandler transactionHandler;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void consume(MetricRequest message) {
        logger.info("The following parameters were consumed: " + message.toString());
        transactionHandler.saveMetricTransaction(message.getPeriodInterval(), message.getPeriodDate(),
                message.getServerName(), message.getOriginId(), message.getTransactionClass(),
                message.getTransactionType(), message.getPeriodType(), message.getTransactionResult(),
                message.getTransactionDuration());
    }
}
