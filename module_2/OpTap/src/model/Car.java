package model;

public class Car extends Vehicle{
    //+ Ôtô có thêm các thuộc tính : Số chỗ ngồi, kiểu xe (du lịch, xe khách).
    private String seat;
    private String type;

//    public Car(String palate, String nameProduction, int yearProduct, String owner, String seat) {
//        super(palate, nameProduction, yearProduct, owner);
//        this.seat = seat;
//    }


    public Car(String palate, String nameProduction, int yearProduct, String owner, String seat, String type) {
        super(palate, nameProduction, yearProduct, owner);
        this.seat = seat;
        this.type = type;
    }



    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    @Override
//    public String toString() {
//        return String.format("%s,3,%s,%s",super.toString(),type,seat);
//
//    }


    @Override
    public void showInfo() {

    }

}
