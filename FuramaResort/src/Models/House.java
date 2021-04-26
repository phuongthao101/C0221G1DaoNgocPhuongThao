package Models;

public class House extends Services {
    private String standardRoom;
    private String otherDescription;
    private int numberOfFloor;

    public House(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople, String typeOfRent, String standardRoom, String otherDescription, int numberOfFloor) {
        super(id, nameServices, areaUsed, rentalCost, amountOfPeople, typeOfRent);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.numberOfFloor = numberOfFloor;
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
// sử dụng phương thức showInfor() để hiển thị thông tin của đối tượng vừa được tạo.
    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}'+ super.toString();
    }

    @Override
    public void showInfor() {

        System.out.println(this.toString());
    }
}
