package model.bean.CustomerService;

public class CustomerUsing {
//    select customer.customer_id, customer.customer_name, customer.phone, service.service_name,contract.contract_id,
//    contract.start_date,contract.end_date,attach_service.attach_service_name,contract_detail.quantity

    private int customerId;
    private String customerName;
    private String phone;
    private String service_name;
    private int contractId;
    private String startDate;
    private String endDate;
    private String attachServiceName;
    private int quantity;

    public CustomerUsing() {
    }

    public CustomerUsing(int customerId, String customerName, String phone, String service_name,
                         int contractId, String startDate, String endDate, String attachServiceName, int quantity) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.service_name = service_name;
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attachServiceName = attachServiceName;
        this.quantity = quantity;
    }

    public CustomerUsing(String customerName, String phone, String service_name, int contractId, String startDate, String endDate, String attachServiceName, int quantity) {
        this.customerName = customerName;
        this.phone = phone;
        this.service_name = service_name;
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attachServiceName = attachServiceName;
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
