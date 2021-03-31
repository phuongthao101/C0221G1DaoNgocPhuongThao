package bai_1_java_introduction.bai_tap.so_thanh_chu;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number : ");
        int number = Integer.parseInt(scanner.nextLine());
        int numberInput = number;
        String[] arrayNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] arrayNum20 = {"twenty", "thirty", "forty", "fify", "sixties", "seventies", "eighty", "ninety"};
        String strNum = "";
        if (number < 20) {
            strNum = arrayNum[number];
        } else {
            if (number < 100) {
                strNum += arrayNum20[number / 10 - 2];
                strNum += " " + arrayNum[number % 10];
            } else {
                strNum += arrayNum[number / 100] + " hundred ";
                strNum += arrayNum20[(number % 100) / 10 - 2];
                strNum += " " + arrayNum[number % 10];
            }

        }

        System.out.println(numberInput + " read : " + strNum);
    }
}
