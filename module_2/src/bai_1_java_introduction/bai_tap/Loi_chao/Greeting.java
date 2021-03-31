package bai_1_java_introduction.bai_tap.Loi_chao;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println(" Enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello " + name );
    }
}
