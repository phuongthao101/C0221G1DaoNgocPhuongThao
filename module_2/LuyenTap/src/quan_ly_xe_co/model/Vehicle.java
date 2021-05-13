package quan_ly_xe_co.model;

public class Vehicle {
private String numberPalate;
private String production;
private int yearOfProduction;
private String owner;

    public Vehicle(String numberPalate, String production, int yearOfProduction, String owner) {
        this.numberPalate = numberPalate;
        this.production = production;
        this.yearOfProduction = yearOfProduction;
        this.owner = owner;
    }

    public Vehicle() {

    }


    public String getNumberPalate() {
        return numberPalate;
    }

    public void setNumberPalate(String numberPalate) {
        this.numberPalate = numberPalate;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return
                numberPalate +
                ","+  production +
                 ","+ yearOfProduction +","
                + owner + ","
                ;
    }
}
