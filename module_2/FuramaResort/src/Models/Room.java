package Models;

public class Room extends Services {
    private String extraService;

    public Room(String string2, String s1, String string1, String s, String string, String extraService, ExtraService service) {
        this.extraService = extraService;
    }

    public Room(String id1, String s, String area, String id, String name, String areaUse, String cost, String maxPeople,
                String rentType, String extraService) {
        super(id, name, areaUse, cost, maxPeople, rentType);
        this.extraService = extraService;
    }

    public Room(String id, String name, String idRoom, String nameRoom, String areaRoom, String costRoom, String peopleRoom, String rentTypeRoom, String extraService) {
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
