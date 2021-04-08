package bai_2_loop.thuc_hanh;

import java.util.Scanner;

public class kiem_tra_so_nguyen_to {
    public static boolean KiemTraSoNguyenTo(int number) {
        if (number < 2) {
            return false;
        } else {
            int i = 2;
            for ( i = 2 ; i < number ; i++){
                if (number%i == 0 ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = Integer.parseInt(scanner.nextLine());
                if (KiemTraSoNguyenTo(number))
                    System.out.println(number + " is a prime");
                else
                    System.out.println(number + " is not a prime");
            }

        }



