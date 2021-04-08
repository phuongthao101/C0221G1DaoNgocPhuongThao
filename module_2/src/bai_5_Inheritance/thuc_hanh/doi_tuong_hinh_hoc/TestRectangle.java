package bai_5_Inheritance.thuc_hanh.doi_tuong_hinh_hoc;

import bai_5_Inheritance.thuc_hanh.doi_tuong_hinh_hoc.Rectangle;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        Rectangle rectangle1 = new Rectangle("blue", true,20,15);
        System.out.println(rectangle1);
    }
}
