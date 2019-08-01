package bs2.commons.metrics;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * Tests for MetricQueuePublisher.
 * 
 * @author Anton Nazarov
 * @since 01/08/2019
 */
public class MetricQueuePublisherTest {

    MetricQueuePublisher publisher;
    Source source;
    MessageChannel channel;

    @Before
    public void setUp() {
        source = Mockito.mock(Source.class);
        channel = Mockito.mock(MessageChannel.class);
        publisher = new MetricQueuePublisher(source);

        when(source.output()).thenReturn(channel);
    }

    @Test
    public void testPublish() {
        publisher.publish("serverName", "originId", "transactionClass", "transactionType", "transactionResult", 10000);
        verify(channel, times(1)).send(any(Message.class));
    }
}
