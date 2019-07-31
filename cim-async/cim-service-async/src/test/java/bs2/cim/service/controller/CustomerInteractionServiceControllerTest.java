package bs2.cim.service.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * The tests for CustomerInteractionServiceController.
 * 
 * @author Anton Nazarov
 * @since 31/07/2019
 */
public class CustomerInteractionServiceControllerTest {

    CustomerInteractionServiceController controller;
    CIMHandler handler = Mockito.mock(CIMHandler.class);

    @Before
    public void setUp() {
        controller = new CustomerInteractionServiceController();
        controller.cimHandler = handler;
    }

    @Test
    public void testStoreCustomerInteraction() {
        controller.storeCustomerInteraction("subscriberSeq", "subId", "subIdType", "subscriberType", "spName",
                "interactionDate", "callId", "userName", "accountId", "source", "topicCode", "comment");
        verify(handler, times(1)).handle("subscriberSeq", "subId", "subIdType", "subscriberType", "spName",
                "interactionDate", "callId", "userName", "accountId", "source", "topicCode", "comment");
    }
}
