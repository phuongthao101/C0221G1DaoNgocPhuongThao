package bai_1_java_introduction.thuc_hanh.su_dung_toan_tu;
import java.util.Scanner;

public class RectangleProgram {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width");
        width = Float.parseFloat(scanner.nextLine());

        System.out.println("Enter height");
        height = Float.parseFloat(scanner.nextLine());

        float area = width * height;
        System.out.println("Area is: " + area);


    }
}

