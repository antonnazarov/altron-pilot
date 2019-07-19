package bs2.commons.metrics;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The metricable functionality driving aspect.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
@Aspect
@Component
public class MetricAspect {

    @Autowired
    MetricQueuePublisher publisher;

    @Around("@annotation(Metricable)")
    public Object logMetric(ProceedingJoinPoint joinPoint) throws Throwable {
        // get the actual annotation of the target method
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Metricable m = method.getAnnotation(Metricable.class);
        Object proceed = null;
        if (m != null) {

            long start = System.currentTimeMillis();
            try {
                proceed = joinPoint.proceed();
            } catch (Throwable t) {
                long executionTime = System.currentTimeMillis() - start;
                publisher.publish(m.serverName(), m.originId(), m.transactionClass().name(), m.transactionType(),
                        "EXCEPTION", executionTime);
                throw t;
            }

            long executionTime = System.currentTimeMillis() - start;
            publisher.publish(m.serverName(), m.originId(), m.transactionClass().name(), m.transactionType(), "SUCCESS",
                    executionTime);
        } else {
            proceed = joinPoint.proceed();
        }

        return proceed;
    }
}
