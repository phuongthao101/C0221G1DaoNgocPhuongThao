package bai_5_Inheritance.bai_tap.lop_circle_va_Cylinder;

public class TestCylinder {
    public static void main(String[] args) {
        Circle circle =new Circle();
        System.out.println(circle);

        Cylinder cylinder = new Cylinder(25,"blue", 25 );
        System.out.println(cylinder);
    }
}
