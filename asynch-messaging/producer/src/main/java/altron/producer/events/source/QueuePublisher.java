package altron.producer.events.source;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import altron.producer.events.model.MyRequestModel;

/**
 * This component publishes messages into the message broker.
 * 
 * @author Anton Nazarov
 * @since 12/07/2019
 */
@Component
public class QueuePublisher {

    private static final Logger logger = LoggerFactory.getLogger(QueuePublisher.class);

    private Source source;

    @Autowired
    public QueuePublisher(Source source) {
        this.source = source;
    }

    public void publish(String firstName, String secondName, java.util.Date timestamp) {
        logger.info("the publisher has been called");

        MyRequestModel model = new MyRequestModel(firstName, secondName, timestamp, UUID.randomUUID().toString());
        source.output().send(MessageBuilder.withPayload(model).build());
        
        logger.info("the following payload has been published: " + model.toString()); 
    }
}
