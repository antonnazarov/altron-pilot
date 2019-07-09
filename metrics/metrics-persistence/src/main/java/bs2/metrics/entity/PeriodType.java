package bs2.metrics.entity;

public enum PeriodType {
    
    ONE_HOUR ("1HOUR"), TEN_MINUTES("10MIN");
    
    private String typeName = null;
    
    private PeriodType(String typeName) {
        this.typeName = typeName;
    }
    
    @Override
    public String toString() {
        return typeName;
    }
}
