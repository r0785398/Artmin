package artmin.model;


public class Crowd {

    private int crowdQty;
    private int crowdsAvgAge;
    private String crowdInformation;
    private boolean crowdAck; 

    public int getCrowdQty() {
        return crowdQty;
    }

    public void setCrowdQty(int crowdQty) {
        this.crowdQty = crowdQty;
    }

    public int getCrowdsAvgAge() {
        return crowdsAvgAge;
    }

    public void setCrowdsAvgAge(int crowdsAvgAge) {
        this.crowdsAvgAge = crowdsAvgAge;
    }

    public String getCrowdInformation() {
        return crowdInformation;
    }

    public void setCrowdInformation(String crowdInformation) {
        this.crowdInformation = crowdInformation;
    }

    public boolean isCrowdAck() {
        return crowdAck;
    }

    public void setCrowdAck(boolean crowdAck) {
        this.crowdAck = crowdAck;
    }
    
    
}
