package bai_1_java_introduction.bai_tap;

import java.util.Scanner;

public class Unitled {
    public static void main(String[] args) {
        int rate = 23000;

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter USD");
        int usd = Integer.parseInt(scanner.nextLine());
        int vnd = usd * rate;
        System.out.println(" VND is " + vnd);

    }
}
