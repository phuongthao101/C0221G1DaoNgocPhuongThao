package Models;

public abstract class Services {
    private String id;
    private String nameServices;
    private float areaUsed;
    private float rentalCost;
    private int amountOfPeople;
    private String typeOfRent;

    public Services(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople, String typeOfRent) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUsed = areaUsed;
        this.rentalCost = rentalCost;
        this.amountOfPeople = amountOfPeople;
        this.typeOfRent = typeOfRent;
    }

    public Services() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public float getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(float areaUsed) {
        this.areaUsed = areaUsed;
    }

    public float getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(float rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }
    public abstract String showInfor();


}
