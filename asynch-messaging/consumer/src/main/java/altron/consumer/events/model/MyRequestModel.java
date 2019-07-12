package altron.consumer.events.model;

import java.io.Serializable;

public class MyRequestModel implements Serializable {

    private static final long serialVersionUID = 2829163317729361076L;

    private String firstName;
    private String secondName;
    private java.util.Date timestamp;
    private String correlationId;

    public MyRequestModel(String firstName, String secondName, java.util.Date timestamp, String correlationId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.timestamp = timestamp;
        this.correlationId = correlationId;
    }

    public MyRequestModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public java.util.Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.util.Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Override
    public String toString() {
        return "MyRequestModel [firstName=" + firstName + ", secondName=" + secondName + ", timestamp=" + timestamp
                + ", correlationId=" + correlationId + "]";
    }
}
