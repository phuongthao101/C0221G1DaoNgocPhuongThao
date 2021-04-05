package bai_4_oop.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    double width, height;
    public Rectangle() {

    }
    public Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }
    public double getPerimeter(){
        return (this.height + this.width) *2;

    }
    public String display(){
        return "Rectangle {" + "width=" + width + ", height=" + height + "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width");
        double width = scanner.nextDouble();
        System.out.println("Enter height");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(height,width); //Khởi tạo một đối tượng thuộc lớp Rectangle với phương thức khởi tạo chứa 2 tham số width, height

        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }

}
