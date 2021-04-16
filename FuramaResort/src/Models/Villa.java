package Models;

public class Villa extends House {

    private float poolArea;

    public Villa(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople, String typeOfRent, String standardRoom, String comfortDescription, int numberOfFloor, float poolArea) {
        super(id, nameServices, areaUsed, rentalCost, amountOfPeople, typeOfRent, standardRoom, comfortDescription, numberOfFloor);
        this.poolArea = poolArea;
    }

    public Villa(String standardRoom, String comfortDescription, int numberOfFloor, float poolArea) {
        super(standardRoom, comfortDescription, numberOfFloor);
        this.poolArea = poolArea;
    }

    public Villa(float poolArea) {
        this.poolArea = poolArea;
    }
    public Villa(){


    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
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
                " \n Numberoffloors: " + this.getNumberOfFloor()+
                "\nPoolArea: " + this.getPoolArea();
    }
}
