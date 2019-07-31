package bs2.cim.service.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bs2.cim.persistence.handler.ScratchPadTransferHandler;
import bs2.cim.persistence.handler.SmsTransferHandler;

/**
 * The tests for CIMHandler.
 * 
 * @author Anton Nazarov
 * @since 31/07/2019
 */
public class CIMHandlerTest {

    CIMHandler handler;
    ScratchPadTransferHandler sptHandler;
    SmsTransferHandler smstHandler;

    @Before
    public void setUp() {
        handler = new CIMHandler();
        sptHandler = Mockito.mock(ScratchPadTransferHandler.class);
        smstHandler = Mockito.mock(SmsTransferHandler.class);

        handler.scratchPadHandler = sptHandler;
        handler.smsHandler = smstHandler;
    }

    @Test
    public void testInsertScratchPadEntry() {
        handler.handle("subscriberSeq", "subId", "subIdType", "subscriberType", "spName", "interactionDate", "callId",
                "userName", "accountId", "source", "topicCode", "comment");
        verify(sptHandler, times(1)).insertScratchPadEntry(eq("subscriberSeq"), eq("subId"), eq("subIdType"),
                eq("subscriberType"), eq("spName"), any(java.util.Date.class), eq("callId"), eq("userName"),
                eq("accountId"), eq("source"), eq("topicCode"), eq("comment"));
    }

    @Test
    public void testInsertSmsEntry() {
        handler.handle("subscriberSeq", "subId", "subIdType", "subscriberType", "spName", "interactionDate", "callId",
                "userName", "accountId", "source", "<topicCode>", "comment");
        verify(smstHandler, times(1)).insertSmsEntry(eq("subscriberSeq"), eq("subId"), eq("subIdType"),
                eq("subscriberType"), eq("spName"), any(java.util.Date.class), eq("callId"), eq("userName"),
                eq("accountId"), eq("source"), eq("<topicCode>"), eq("comment"));
    }
}
