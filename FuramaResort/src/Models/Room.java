package Models;

public abstract class Room extends Services {
    private String freeServices;

    public Room(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople, String typeOfRent, String freeServices) {
        super(id, nameServices, areaUsed, rentalCost, amountOfPeople, typeOfRent);
        this.freeServices = freeServices;
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }
    public Room(){

    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
    @Override
    public String showInfor() {
        return "\nNameServices" + super.getNameServices() +
                " \nAreaused" + super.getAreaUsed() +
                " \nrentalcosts" + super.getRentalCost() +
                "\namountofpeople" + super.getAmountOfPeople() +
                "\ntypeofrent" + super.getTypeOfRent() +
                "\nid" + super.getId() +
                "\nFreeServices: " + this.getFreeServices();
    }
}
