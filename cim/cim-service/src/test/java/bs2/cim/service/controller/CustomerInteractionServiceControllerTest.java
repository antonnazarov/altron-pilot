package bs2.cim.service.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bs2.cim.persistence.handler.ScratchPadTransferHandler;
import bs2.cim.persistence.handler.SmsTransferHandler;

/**
 * The tests for CustomerInteractionServiceController.
 * 
 * @author Anton Nazarov
 * @since 31/07/2019
 */
public class CustomerInteractionServiceControllerTest {

    CustomerInteractionServiceController controller;
    ScratchPadTransferHandler sptHandler;
    SmsTransferHandler smstHandler;

    @Before
    public void setUp() {
        controller = new CustomerInteractionServiceController();
        sptHandler = Mockito.mock(ScratchPadTransferHandler.class);
        smstHandler = Mockito.mock(SmsTransferHandler.class);
        controller.scratchPadHandler = sptHandler;
        controller.smsHandler = smstHandler;
    }

    @Test
    public void testInsertScratchPadEntry() {
        controller.storeCustomerInteraction("subscriberSeq", "subId", "subIdType", "subscriberType", "spName",
                "interactionDate", "callId", "userName", "accountId", "source", "topicCode", "comment");
        verify(sptHandler, times(1)).insertScratchPadEntry(eq("subscriberSeq"), eq("subId"), eq("subIdType"),
                eq("subscriberType"), eq("spName"), any(java.util.Date.class), eq("callId"), eq("userName"),
                eq("accountId"), eq("source"), eq("topicCode"), eq("comment"));
    }
    
    @Test
    public void testInsertSmsEntry() {
        controller.storeCustomerInteraction("subscriberSeq", "subId", "subIdType", "subscriberType", "spName", "interactionDate", "callId",
                "userName", "accountId", "source", "<topicCode>", "comment");
        verify(smstHandler, times(1)).insertSmsEntry(eq("subscriberSeq"), eq("subId"), eq("subIdType"),
                eq("subscriberType"), eq("spName"), any(java.util.Date.class), eq("callId"), eq("userName"),
                eq("accountId"), eq("source"), eq("<topicCode>"), eq("comment"));
    }
}
