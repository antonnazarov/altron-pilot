package bs2.metrics.entity;

public enum TransactionClass {
    
    UNKNOWN(""), QUERY("Q"), PROVISION("P"), SYNCTHRU(null);
    
    private String classId = null;
    
    private TransactionClass(String classId) {
        this.classId = classId;
    }
    
    public String getClassId() {
        return classId;
    }
}
