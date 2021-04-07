package bai_5_Inheritance.bai_tap.lop_triangle;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape("red", true);
        System.out.println(shape.toString());
        Triangle triangle = new Triangle("red", false, 2.5,3.0,4.5);
        System.out.println(triangle.toString());
    }
}
