package quan_ly_xe_co.model;

public class Bike extends Vehicle {
    private int power;

    public Bike(String numberPalate, String production, int yearOfProduction, String owner, int power) {
        super(numberPalate, production, yearOfProduction, owner);
        this.power = power;
    }

    public Bike(int power) {
        this.power = power;
    }

    public Bike() {
    }

    public Bike(String s, String s1, String s2, String s3) {
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString()+
                + power
                ;
    }
}
