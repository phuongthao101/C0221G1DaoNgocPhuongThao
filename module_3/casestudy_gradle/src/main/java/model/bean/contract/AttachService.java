package model.bean.contract;

public class AttachService {


    private int attachServiceId;
    private String attachServiceName;
    private double cost;
    private int uint;
    private String status;

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, double cost, int uint, String status) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.cost = cost;
        this.uint = uint;
        this.status = status;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUint() {
        return uint;
    }

    public void setUint(int uint) {
        this.uint = uint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
