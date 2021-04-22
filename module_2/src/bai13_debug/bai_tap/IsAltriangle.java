package bai13_debug.bai_tap;

import java.util.Scanner;

public class IsAltriangle {
    public static void main(String[] args){
        try {
            isATriangle();
        }
        catch (IllegalTriangleException ex){
            System.out.println(ex);
        }
    }
    public static void isATriangle() throws IllegalTriangleException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter c: ");
        int c = Integer.parseInt(scanner.nextLine());
        if(a<0 || b<0 || c <0){
            throw new IllegalTriangleException();
        }
        if(a+b > c && a+c > b && b+c > a){
            System.out.printf("%d, %d, %d is three sides of a triangle",a,b,c);
        }
        else {
            throw new IllegalTriangleException();
        }
    }
    public static class IllegalTriangleException  extends Exception{
        public IllegalTriangleException(){
            super("The sum of any two sides is greater than the other side");
        }

    }
}
