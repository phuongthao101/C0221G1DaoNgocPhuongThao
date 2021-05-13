package Models;

public class House extends Services {
    private String standardRoom;
    private String description;
    private String floors;


    public House(String standardRoom, String description, String floors) {
        this.standardRoom = standardRoom;
        this.description = description;
        this.floors = floors;
    }

    public House(String id, String name, String areaUse, String cost, String maxPeople, String rentType, String standardRoom, String description, String floors) {
        super(id, name, areaUse, cost, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.description = description;
        this.floors = floors;
    }

    public House() {
    }

    public House(String string, double parseDouble, double parseDouble1, int parseInt, String string1, String string2, String string3, int parseInt1) {
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return standardRoom+
                "," + description +
                "," + floors +
                "," + id +
                "," + name +
                "," + areaUse +
                "," + cost + '\'' +
                "," + maxPeople +
                "," + rentType
                ;
    }

    @Override
    public String showInfor() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", description='" + description + '\'' +
                ", floors='" + floors + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaUse='" + areaUse + '\'' +
                ", cost='" + cost + '\'' +
                ", maxPeople='" + maxPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
