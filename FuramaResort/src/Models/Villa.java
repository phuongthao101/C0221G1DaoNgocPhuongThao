package Models;

public class Villa extends Services{

    private String standardRoom;
    private String otherDescription;
    private int numberOfFloor;
    private float areaPool;

    public Villa(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople, String typeOfRent, String standardRoom, String otherDescription, int numberOfFloor, float areaPool) {
        super(id, nameServices, areaUsed, rentalCost, amountOfPeople, typeOfRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloor = numberOfFloor;
        this.areaPool = areaPool;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public float getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(float areaPool) {
        this.areaPool = areaPool;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                ", areaPool=" + areaPool +
                '}' + super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }

}
