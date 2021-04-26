package quan_ly_hoa_don;

public class VNCustomer {
   private int id;
   private String name;
   private String typeCustomer;
   private float standardUse;

    public VNCustomer(int id, String name, String typeCustomer, float standardUse) {
        this.id = id;
        this.name = name;
        this.typeCustomer = typeCustomer;
        this.standardUse = standardUse;
    }

    public VNCustomer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public float getStandardUse() {
        return standardUse;
    }

    public void setStandardUse(float standardUse) {
        this.standardUse = standardUse;
    }
}
