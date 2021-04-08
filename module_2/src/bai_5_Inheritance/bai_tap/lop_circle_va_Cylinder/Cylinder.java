package bai_5_Inheritance.bai_tap.lop_circle_va_Cylinder;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getV(){
        return  this.height * getRadius() * 2 * Math.PI ;

    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}'+ "thể tích" + getV();
    }
}
