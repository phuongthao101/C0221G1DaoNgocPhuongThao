package model;
//Xe máy có thêm thuộc tính: Công suất.
public class Bike extends Vehicle {
    private Double power;

    public Bike(String palate, String nameProduction, int yearProduct, String owner, Double power) {
        super(palate, nameProduction, yearProduct, owner);
        this.power = power;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    @Override
    public void showInfo() {


    }

    @Override
    public String toString() {
        return String.format("%s,2,%s",super.toString(),power);

    }
}
