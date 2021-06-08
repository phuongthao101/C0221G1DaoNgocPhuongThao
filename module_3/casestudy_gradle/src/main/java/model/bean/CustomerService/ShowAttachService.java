package model.bean.CustomerService;

public class ShowAttachService {
    private  int contractId;
    private  String attachServiceName;
    private  int quantity;

    public ShowAttachService() {
    }

    public ShowAttachService(int contractId, String attachServiceName, int quantity) {
        this.contractId = contractId;
        this.attachServiceName = attachServiceName;
        this.quantity = quantity;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
