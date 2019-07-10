package bs2.metrics.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IM_TRANSACTION")
public class MetricTransaction implements Serializable {

    private static final long serialVersionUID = -8462414536706514774L;

    public MetricTransaction(java.util.Date createdTime, int periodInterval, java.util.Date periodDate,
            String serverName, String originId, TransactionClass transactionClass, String transactionType,
            PeriodType periodType, TransactionResult result, long duration, RecordStatus status) {
        this.createdTime = createdTime;
        this.periodInterval = periodInterval;
        this.periodDate = periodDate;
        this.serverName = serverName;
        this.originId = originId;
        this.transactionClass = transactionClass;
        this.transactionType = transactionType;
        this.periodType = periodType;
        this.result = result;
        this.duration = duration;
        this.status = status;
    }

    public MetricTransaction() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "im_seq_generator")
    @SequenceGenerator(sequenceName = "IM_SEQ", allocationSize = 1, name = "im_seq_generator")
    private long id;

    @Column(name = "CREATED_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdTime;

    @Column(name = "PERIOD_INTERVAL")
    private int periodInterval;

    @Column(name = "PERIOD_DT")
    @Temporal(TemporalType.DATE)
    private java.util.Date periodDate;

    @Column(name = "SERVER_NAME")
    private String serverName;

    @Column(name = "ORIGIN_ID")
    private String originId;

    @Column(name = "TRANSACTION_CLASS")
    @Enumerated(EnumType.STRING)
    private TransactionClass transactionClass;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "PERIOD_TYPE")
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    @Column(name = "TRANSACTION_RESULT")
    private TransactionResult result;

    @Column(name = "TRANSACTION_DURATION")
    private long duration;

    @Column(name = "RECORD_STATUS")
    @Enumerated(EnumType.STRING)
    private RecordStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.util.Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(java.util.Date createdTime) {
        this.createdTime = createdTime;
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

    public TransactionClass getTransactionClass() {
        return transactionClass;
    }

    public void setTransactionClass(TransactionClass transactionClass) {
        this.transactionClass = transactionClass;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public PeriodType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public TransactionResult getResult() {
        return result;
    }

    public void setResult(TransactionResult result) {
        this.result = result;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }
}
