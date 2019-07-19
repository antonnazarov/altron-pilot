package bs2.commons.metrics;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * The minimalistic configuration class for testing purposes.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
@EnableBinding(Source.class)
public class TestConfig {

}
