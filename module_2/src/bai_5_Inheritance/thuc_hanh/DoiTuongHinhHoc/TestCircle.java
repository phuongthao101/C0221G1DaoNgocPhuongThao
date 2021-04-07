package bai_5_Inheritance.thuc_hanh.DoiTuongHinhHoc;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("yellow", false, 4);
        System.out.println(circle);
    }
}
