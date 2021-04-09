package bai_6_abstract_interface.bai_tap.Resizeable;

import java.util.Arrays;

public class Main<shapes> {


    public static void main(String[] args) {
        float x = (int) Math.floor((Math.random() * 10));
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(x,"blue",true);
        shapes[1] = new Rectangle(x,x, "blue",false );
        shapes[2] = new Square(x, "yellow", false);

        for (Shape a : shapes) {
            System.out.println(a);
        }

        for (Shape a : shapes) {
            a.resize(Math.random() * 100);
        }

        System.out.println("\n");
        System.out.println(Arrays.toString(shapes));
    }
}


