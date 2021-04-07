package bai_5_Inheritance.bai_tap.lop_point_MoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(2,5);
        System.out.println(point.toString());
        MovablePoint movablePoint = new MovablePoint(3,8,6,7);
        System.out.println(movablePoint.toString());
        movablePoint.move();
        movablePoint.move();
        System.out.println(movablePoint.getX());
        System.out.println(movablePoint.getY());
    }
}
