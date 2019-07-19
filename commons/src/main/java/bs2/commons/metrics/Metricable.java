package bs2.commons.metrics;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The custom annotation for the methods, eligible for the Metric service.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Metricable {
    public String serverName() default "";

    public String originId() default "Transaction:OriginId";

    public TransactionClass transactionClass() default TransactionClass.PROVISION;

    public String transactionType() default "";

    public String periodType() default "1HOUR";
}
