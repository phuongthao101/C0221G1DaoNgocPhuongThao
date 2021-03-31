package bai_1_java_introduction.thuc_hanh.nam_nhuan;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println( " Enter a year");
        int year;
        year = Integer.parseInt(scanner.nextLine());

        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    System.out.println( year+" is a leap year");
                } else {
                    System.out.println(year+" is NOT a leap year");
                }
            } else {
                System.out.println(year+" is a leap year");
            }
        } else {
            System.out.println(year+" is NOT a leap year");
        }
    }
}
