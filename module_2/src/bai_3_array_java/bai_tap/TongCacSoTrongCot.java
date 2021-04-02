package bai_3_array_java.bai_tap;

import java.util.Scanner;

public class TongCacSoTrongCot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        int n;
        System.out.println("Nhập vào kích thước dòng:");
        n = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào kích thước cột:");
        m = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[m][n];
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Mảng " + i + ", " + j);
                array[i][j] = scanner.nextInt();
          }
        }
        System.out.println("Nhập cột bạn muốn tính:");
        int input = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += array[i][input];
            }

        }System.out.println("Tổng cột " + total);
    }
}
