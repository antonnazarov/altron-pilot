package altron.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import altron.consumer.events.model.MyRequestModel;

/**
 * The simple asynchronous message producer service.
 * 
 * @author Anton Nazarov
 * @since 12/07/2019
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class Application {
    
    Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @StreamListener(Sink.INPUT)
    public void consume(MyRequestModel message) {
        logger.info("The following parameters were consumed: " + message.toString());
    }
}
