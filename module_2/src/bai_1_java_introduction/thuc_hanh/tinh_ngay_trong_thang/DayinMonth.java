package bai_1_java_introduction.thuc_hanh.tinh_ngay_trong_thang;

import java.util.Scanner;

public class DayinMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Which month that you want to count day ?");
        int month;
        month = Integer.parseInt(scanner.nextLine());
        switch (month) {
            case 2:
                System.out.print(" The month has 28 or 29 dáy");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("The month '" + month + "' has 31 days!");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("The month '" + month + "' has 30 days!");
                break;
            default:
                System.out.print("Invalid input!");
                break;
        }

    }
}

