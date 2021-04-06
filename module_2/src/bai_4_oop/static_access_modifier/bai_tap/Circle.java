package bai_4_oop.static_access_modifier.bai_tap;

public class Circle {
    public static void main(String[] args) {
        TestCircle testCircle = new TestCircle(15, "blue",3.14);
        System.out.println(testCircle.toString());
    }
}
