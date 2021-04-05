package bai_4_oop.bai_tap.CanBac2;

import java.util.Scanner;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập giá trị a");
        double a = scanner.nextDouble();
        System.out.println(" Nhập giá trị b");
        double b = scanner.nextDouble();
        System.out.println(" Nhập giá trị c");
        double c = scanner.nextDouble();
        QuadraticEquation test = new QuadraticEquation(a,b,c);

        if(test.getDiscriminant() >0){
            System.out.println(" Phương trình có 2 nghiệm : " + test.getRoot1() + " và " + test.getRoot2());
        }
        else if(test.getDiscriminant() == 0){
            System.out.println( " Phương trình có một nghiệm : " + test.getRoot1());
        }
        else {
            System.out.println(" Phương trình vô nghiệm");

        }

    }
}
