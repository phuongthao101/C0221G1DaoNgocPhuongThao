package model;

public abstract class Vehicle {
    protected String palate;
    protected String nameProduction;
    protected int yearProduct;
    protected String owner;

    public Vehicle(String palate, String nameProduction, int yearProduct, String owner) {
        this.palate = palate;
        this.nameProduction = nameProduction;
        this.yearProduct = yearProduct;
        this.owner = owner;
    }

    public Vehicle() {
    }

    public String getPalate() {
        return palate;
    }

    public void setPalate(String palate) {
        this.palate = palate;
    }

    public String getNameProduction() {
        return nameProduction;
    }

    public void setNameProduction(String nameProduction) {
        this.nameProduction = nameProduction;
    }

    public int getYearProduct() {
        return yearProduct;
    }

    public void setYearProduct(int yearProduct) {
        this.yearProduct = yearProduct;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",palate,nameProduction,yearProduct,owner);

    }
    public abstract void showInfo();
}
