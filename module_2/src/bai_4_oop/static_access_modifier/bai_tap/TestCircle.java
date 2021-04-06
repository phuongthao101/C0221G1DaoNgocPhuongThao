package bai_4_oop.static_access_modifier.bai_tap;

public class TestCircle {
    private double radius =1.0;
    private String color = "red";
    private double PI = Math.PI;

    public TestCircle(double radius, String color, double PI) {
        this.radius = radius;
        this.color = color;
        this.PI = PI;
    }
    public TestCircle(){

    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPI(double PI) {
        this.PI = PI;

    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getPI() {
        return PI;
    }
    public double getArea(){
        return this.radius * this.PI;
}

    @Override
    public String toString() {
        return "TestCircle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", PI=" + PI +
                "dien tich =" + getArea() +
                '}';
    }
}
