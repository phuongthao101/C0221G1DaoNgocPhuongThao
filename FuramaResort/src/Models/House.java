package Models;

public class House extends Services {
    private String standardRoom;
    private String comfortDescription;
    private int numberOfFloor;

    public House(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople, String typeOfRent, String standardRoom, String comfortDescription, int numberOfFloor) {
        super(id, nameServices, areaUsed, rentalCost, amountOfPeople, typeOfRent);
        this.standardRoom = standardRoom;
        this.comfortDescription = comfortDescription;
        this.numberOfFloor = numberOfFloor;
    }

    public House(String standardRoom, String comfortDescription, int numberOfFloor) {
        this.standardRoom = standardRoom;
        this.comfortDescription = comfortDescription;
        this.numberOfFloor = numberOfFloor;
    }

    public House() {
    }


    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getComfortDescription() {
        return comfortDescription;
    }

    public void setComfortDescription(String comfortDescription) {
        this.comfortDescription = comfortDescription;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String showInfor() {
        return "\nNameService: " + super.getNameServices() +
                "\nAeraUsed: " + super.getAreaUsed() +
                "\nRentalCost: " + super.getRentalCost() +
                "\nAmountOfPeople: " + super.getAmountOfPeople() +
                "\nTypeOfRent: " + super.getTypeOfRent() +
                " \nid: " + super.getId() +
                " \nRoomstandard: " + this.getStandardRoom() +
                " \nComfortdescription: " + this.getComfortDescription() +
                " \n Numberoffloors: " + this.getNumberOfFloor();

    }
}
