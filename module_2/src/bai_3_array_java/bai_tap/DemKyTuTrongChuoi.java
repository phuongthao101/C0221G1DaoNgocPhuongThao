package bai_3_array_java.bai_tap;

import java.util.Scanner;

public class DemKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "acbnsfgacb";
        char input;
        int count =0;
        System.out.println("Nhập vào ký tự cần tìm :");
        input = scanner.next().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (input == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện ký tự trong chuỗi là: " + count);
    }
}
