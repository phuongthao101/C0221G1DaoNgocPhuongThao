package bai_6_abstract_interface.thuc_hanh.comparator;

import bai_5_Inheritance.thuc_hanh.doi_tuong_hinh_hoc.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }

    public static class TestCircle {
    }

    public static interface TestRectangle {
    }
}

