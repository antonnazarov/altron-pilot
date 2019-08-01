package bs2.commons.metrics;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * The tests for MetricAspect class.
 * 
 * @author Anton Nazarov
 * @since 01/08/2019
 */
public class MetricAspectTest {
    
    MetricQueuePublisher publisher;
    ProceedingJoinPoint jp;
    MethodSignature ms;
    Method mtd;
    Metricable m;
    String proceedObject = "proceed";
    
    MetricAspect aspect;
    
    @Before
    public void setUp() throws Throwable {
        publisher = Mockito.mock(MetricQueuePublisher.class);
        jp = Mockito.mock(ProceedingJoinPoint.class);
        ms = Mockito.mock(MethodSignature.class);
        mtd = Mockito.mock(Method.class);
        m = Mockito.mock(Metricable.class);
        
        when(jp.getSignature()).thenReturn(ms);
        when(ms.getMethod()).thenReturn(mtd);
        when(mtd.getAnnotation(Metricable.class)).thenReturn(m);
        when(jp.proceed()).thenReturn(proceedObject);
        when(m.serverName()).thenReturn("serverName");
        when(m.originId()).thenReturn("originId");
        when(m.transactionClass()).thenReturn(TransactionClass.PROVISION);
        when(m.transactionType()).thenReturn("transactionType");
        
        aspect = new MetricAspect();
        aspect.publisher = publisher;
    }
    
    @Test
    public void testLogMetric() throws Throwable {
        Object ret = aspect.logMetric(jp);
        assertEquals(proceedObject, ret);
    }
}
