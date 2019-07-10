package bs2.metrics.handler;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import bs2.metrics.entity.MetricTransaction;
import bs2.metrics.entity.PeriodType;
import bs2.metrics.entity.RecordStatus;
import bs2.metrics.entity.TransactionClass;
import bs2.metrics.entity.TransactionResult;
import bs2.metrics.repository.TransactionRepository;

/**
 * The operations on MetricTransaction entity.
 * 
 * @author Anton Nazarov
 * @since 10/07/2019
 */
@Component
public class MetricTransactionHandler {

    Logger logger = LoggerFactory.getLogger(MetricTransactionHandler.class);

    @Resource
    TransactionRepository repository;

    public void saveMetricTransaction(int periodInterval, java.util.Date periodDt, String serverName, String originId,
            String transactionClass, String transactionType, String periodType, String transactionResult,
            long transactionDuration) {

        TransactionClass transCls = null;
        PeriodType perTp = null;
        TransactionResult result = null;
        try {
            transCls = TransactionClass.valueOf(transactionClass);
        } catch (IllegalArgumentException ex) {
            logger.error("Saving MetricTransaction: unable to parse the following TransactionClass=[" + transactionClass
                    + "]");
            return;
        }

        try {
            perTp = PeriodType.parsePeriodType(periodType);
        } catch (IllegalArgumentException ex) {
            logger.error("Saving MetricTransaction: unable to parse the following PeriodType=[" + periodType + "]");
            return;
        }

        try {
            result = TransactionResult.valueOf(transactionResult);
        } catch (IllegalArgumentException ex) {
            logger.error("Saving MetricTransaction: unable to parse the following TransactionResult=["
                    + transactionResult + "]");
            return;
        }

        MetricTransaction trn = new MetricTransaction(new java.util.Date(), periodInterval, periodDt, serverName,
                originId, transCls, transactionType, perTp, result, transactionDuration, RecordStatus.NEW);

        repository.save(trn);
    }
}
