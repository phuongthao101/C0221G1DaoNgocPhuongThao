package Models;

public class Room extends Services {
    private ExtraService extraService;

    public Room(ExtraService extraService) {
        this.extraService = extraService;
    }

    public Room(String id, String name, String areaUse, String cost, String maxPeople,
                String rentType, ExtraService extraService) {
        super(id, name, areaUse, cost, maxPeople, rentType);
        this.extraService = extraService;
    }

    public Room(String idRoom, String nameRoom, String areaRoom, String costRoom, String peopleRoom, String rentTypeRoom, String extraService) {
    }


    @Override
    public String toString() {
        return

                "," + id +
                "," + name +
                "," + areaUse +
                "," + cost +
                "," + maxPeople +
                "," + rentType + ","+extraService  ;
    }

    @Override
    public String showInfor() {
        return "Room{" +
                "freeService='" + extraService + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaUse='" + areaUse + '\'' +
                ", cost='" + cost + '\'' +
                ", maxPeople='" + maxPeople + '\'' +
                ", rentType='" + rentType + '\'' +
                '}';
    }
}
