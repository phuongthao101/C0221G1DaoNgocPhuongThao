package Models;

public class Room extends Services {
    private ExtraService extraServices;

    public Room(String id, String nameServices, float areaUsed, float rentalCost, int amountOfPeople,
                String typeOfRent, ExtraService extraServices) {
        super(id, nameServices, areaUsed, rentalCost, amountOfPeople, typeOfRent);
        this.extraServices = extraServices;
    }

    public ExtraService getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(ExtraService extraServices) {
        this.extraServices = extraServices;
    }
    // sử dụng phương thức showInfor() để hiển thị thông tin của đối tượng vừa được tạo.
    @Override
    public String toString() {
        return "Room{" +
                "extraServices=" + extraServices +
                '}' + super.toString();// kế thừa phthuc lớp cha
    }

    @Override
    public void showInfor() {

        System.out.println(this.toString());
    }
}
