package quan_ly_hoa_don;

public class Invoice {
    private  int idInvoice ;
    private int idCustomer ;
    private  String dateInvoice;
    private Float used;
    private  Float price;
    private   Float total;

    public Invoice() {
    }

    public Invoice(int idInvoice, int idCustomer, String dateInvoice, Float used, Float price, Float total) {
        this.idInvoice = idInvoice;
        this.idCustomer = idCustomer;
        this.dateInvoice = dateInvoice;
        this.used = used;
        this.price = price;
        this.total = total;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(String dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    public Float getUsed() {
        return used;
    }

    public void setUsed(Float used) {
        this.used = used;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
