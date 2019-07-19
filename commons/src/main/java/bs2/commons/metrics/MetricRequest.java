package bs2.commons.metrics;

import java.io.Serializable;

/**
 * The POJO used to publish/handle the Metric- service requests.
 * 
 * @author Anton Nazarov
 * @since 17/07/2019
 */
public class MetricRequest implements Serializable {

    private static final long serialVersionUID = -5253236969266383889L;

    private int periodInterval;
    private java.util.Date periodDate;
    private String serverName;
    private String originId;
    private String transactionClass;
    private String transactionType;
    private String transactionResult;
    private long transactionDuration;
    private String periodType;

    public MetricRequest(int periodInterval, java.util.Date periodDate, String serverName, String originId,
            String transactionClass, String transactionType, String transactionResult, long transactionDuration,
            String periodType) {
        this.periodInterval = periodInterval;
        this.periodDate = periodDate;
        this.serverName = serverName;
        this.originId = originId;
        this.transactionClass = transactionClass;
        this.transactionType = transactionType;
        this.transactionResult = transactionResult;
        this.periodType = periodType;
    }

    public int getPeriodInterval() {
        return periodInterval;
    }

    public void setPeriodInterval(int periodInterval) {
        this.periodInterval = periodInterval;
    }

    public java.util.Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(java.util.Date periodDate) {
        this.periodDate = periodDate;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getTransactionClass() {
        return transactionClass;
    }

    public void setTransactionClass(String transactionClass) {
        this.transactionClass = transactionClass;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionResult() {
        return transactionResult;
    }

    public void setTransactionResult(String transactionResult) {
        this.transactionResult = transactionResult;
    }

    public long getTransactionDuration() {
        return transactionDuration;
    }

    public void setTransactionDuration(long transactionDuration) {
        this.transactionDuration = transactionDuration;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    @Override
    public String toString() {
        return "MetricRequest [periodInterval=" + periodInterval + ", periodDate=" + periodDate + ", serverName="
                + serverName + ", originId=" + originId + ", transactionClass=" + transactionClass
                + ", transactionType=" + transactionType + ", transactionResult=" + transactionResult
                + ", transactionDuration=" + transactionDuration + "]";
    }
}
