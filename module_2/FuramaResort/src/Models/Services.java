package Models;

public abstract class Services {
    protected String id;
    //    public static String ID_REGEX="^[]";
    protected String name;
    protected String areaUse;
    protected String cost;
    protected String maxPeople;
    protected String rentType;

    public Services() {
    }

    public Services(String id, String name, String areaUse, String cost, String maxPeople, String rentType) {
        this.id = id;
        this.name = name;
        this.areaUse = areaUse;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(String areaUse) {
        this.areaUse = areaUse;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String  showInfor() {
        return  "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaUse='" + areaUse + '\'' +
                ", cost='" + cost + '\'' +
                ", maxPeople='" + maxPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return
                 id + "," +
                 name + ","+
                 areaUse +
                ", " + cost +
                "," + maxPeople +
                "," + rentType;
    }


}
