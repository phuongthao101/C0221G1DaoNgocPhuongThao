package bai_6_abstract_interface.thuc_hanh.comparable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle("red", false, 3.5);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
//    ArrayList<ComparableCircle> hinh = new ArrayList<>() ;
//    Circle hinh1 = new ComparableCircle();
//    hinh.add((ComparableCircle) hinh1);
//            hinh.add(new ComparableCircle(10 , "blue"));
//            hinh.add(new ComparableCircle(12 , "red"));
//            hinh.add(new ComparableCircle(16 , "black"));
//            hinh.add(new ComparableCircle(14 , "blue"));
//            hinh.add(new ComparableCircle(17 , "red"));
//            hinh.add(new ComparableCircle());
//            hinh.add(new ComparableCircle());
//            Collections.sort(hinh);
//            for (ComparableCircle iteam : hinh){
//            System.out.println(iteam);