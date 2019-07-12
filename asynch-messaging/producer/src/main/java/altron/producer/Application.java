package altron.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * The simple asynchronous message producer service.
 * 
 * @author Anton Nazarov
 * @since 12/07/2019
 */
@SpringBootApplication
@EnableBinding(Source.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
