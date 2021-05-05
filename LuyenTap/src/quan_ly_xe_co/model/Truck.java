package quan_ly_xe_co.model;

public class Truck extends Vehicle {
    private int weight;

    public Truck(String numberPalate, String production, int yearOfProduction, String owner, int weight) {
        super(numberPalate, production, yearOfProduction, owner);
        this.weight = weight;
    }

    public Truck(String numberPalate, String production, String owner, int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() +
              + weight
              ;
    }
}