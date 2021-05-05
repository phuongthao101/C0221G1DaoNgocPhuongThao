package Models;

public class Villa extends Services{
    private String standardRoom;
    private String otherDescription;
    private String poolArea;
    private String numberOfFloor;

    public Villa(String standardRoom, String otherDescription, String poolArea, String numberOfFloor) {
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String id, String name, String areaUse, String cost, String maxPeople, String rentType, String standardRoom, String otherDescription, String poolArea, String numberOfFloor) {
        super(id, name, areaUse, cost, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa() {
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

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString() + ","+
                standardRoom +
                "," + otherDescription +
                "," + poolArea +
                "," + numberOfFloor   ;
    }

    @Override
    public String showInfor() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", numberOfFloor='" + numberOfFloor + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaUse='" + areaUse + '\'' +
                ", cost='" + cost + '\'' +
                ", maxPeople='" + maxPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}

