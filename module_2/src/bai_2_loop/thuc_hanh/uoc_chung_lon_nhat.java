package bai_2_loop.thuc_hanh;

import java.util.Scanner;

public class uoc_chung_lon_nhat {
    public static void main(String[] args) {
        int a,b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a");
        a= Integer.parseInt(scanner.nextLine());
        System.out.println("Enter b");
        b= Integer.parseInt(scanner.nextLine());
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while(a!=b){
            if(a>b){
                a = a - b;
            }else {
                b = b - a;
            }

        }System.out.println("Greatest common factor: " + a);
    }
}
