package bai_2_loop.thuc_hanh;

import java.util.Scanner;

public class LaiVay {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interest_rate = 1.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter investment amount:");
        money = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number of months: ");
        month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter annual interest rate in percentage: ");
        interest_rate = Double.parseDouble(scanner.nextLine());

        double total_interest = 0;
        for (int i = 0; i < month; i++) {
            total_interest += money * (interest_rate / 100) / 12 * month;

        }
        System.out.println("Total of interset: " + total_interest);

    }
}
