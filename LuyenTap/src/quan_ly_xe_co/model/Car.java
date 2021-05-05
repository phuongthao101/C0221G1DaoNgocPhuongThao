package quan_ly_xe_co.model;

public class Car extends Vehicle {
    private int numberOfSeat;
    private String typeOfCar;

    public Car(String numberPalate, String production, int yearOfProduction, String owner, int numberOfSeat, String typeOfCar) {
        super(numberPalate, production, yearOfProduction, owner);
        this.numberOfSeat = numberOfSeat;
        this.typeOfCar = typeOfCar;
    }

    public Car(int numberOfSeat, String typeOfCar) {
        this.numberOfSeat = numberOfSeat;
        this.typeOfCar = typeOfCar;
    }


    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return super.toString()+
                + numberOfSeat +
                "," + typeOfCar ;
    }
}
