package bai_3_array_java.thuc_hanh;

import java.util.Scanner;

public class ChuyenDoiNhietDo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double doC;
        double doF;
        int chon;
        do {
            System.out.println("Menu");
            System.out.println("1. Đổi độ C sang độ F");
            System.out.println("2. Đổi độ F sang độ C");
            System.out.println("0. Exit ");
            System.out.println("Nhập vào lựa chọn của bạn");
            chon = input.nextInt();
            switch (chon) {
                case 1:
                    System.out.println(" Nhập độ C");
                    doC = input.nextDouble();
                    System.out.println(ChuyenDoCSangF(doC));
                    break;
                case 2:
                    System.out.println(" Nhập độ C");
                    doF = input.nextDouble();
                    System.out.println(ChuyenDoFSangC(doF));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (chon != 0);
    }

    public static  double ChuyenDoCSangF(double doC) {
        double doF = (9.0 / 5) * doC + 32;
        return doF;
    }
    public static double ChuyenDoFSangC(double doF) {
        double doC = (5.0 / 9) * (doF - 32);
        return doC;
    }
}
