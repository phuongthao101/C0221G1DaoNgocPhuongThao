package quan_ly_hoa_don;

public class ForeignCustomer {
    private int id;
    private String name;
    private String nation;

    public ForeignCustomer() {
    }

    public ForeignCustomer(int id, String name, String nation) {
        this.id = id;
        this.name = name;
        this.nation = nation;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
