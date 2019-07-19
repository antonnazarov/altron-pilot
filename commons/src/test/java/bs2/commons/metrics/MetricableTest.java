package bs2.commons.metrics;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;;

/**
 * Testing the Metricable annotation.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class MetricableTest {

    @Autowired
    Heux heux;

    @Metricable(serverName = "testServer", transactionType = "ADCMDN")
    public String callMe(boolean success) throws Exception {
        String out = heux.hello();
        System.out.println("Heux::hello() has been called: " + out);
        if (success) {
            Thread.sleep(2000);
        } else {
            new Exception("Something went wrong");
        }

        return "OK";
    }

    // @Test
    public void testSuccess() throws Exception {
        System.out.println(new java.util.Date());
        callMe(true);
        System.out.println("callMe(true) was successfully called (" + new java.util.Date() + ")");
    }
}
