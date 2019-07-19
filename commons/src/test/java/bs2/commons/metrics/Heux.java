package bs2.commons.metrics;

import org.springframework.stereotype.Component;

/**
 * Simple component for testing of the Spring context.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
@Component
public class Heux {
    
    @Metricable(serverName = "testServer", transactionType = "ADCMDN")
    public String hello() {
        return "Hello from Heux!";
    }
}
