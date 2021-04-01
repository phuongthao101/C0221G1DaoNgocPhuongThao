package bai_2_loop.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        System.out.println("Danh Sach ");
        System.out.println("1. Hình chữ nhật ");
        System.out.println("2. Tam giác vuông bên trái ");
        System.out.println("3. Tam giác vuông bên phải ");
        System.out.println("4. Thoát ");
        int chose = scanner.nextInt();
        do {
            System.out.println("Nhập chiều dài cạnh : ");
            n = scanner.nextInt();
            switch (chose) {
                case 1:

                    for (int i = 1; i <= n; i++) {
                        for (int k = 1; k <= n; k++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;


                case 2:

                    for (int i = 1; i <= n; i++) {
                        for (int k = 1; k <= i; k++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }

                    break;


                case 3:

                    for (int i = 1; i <= n; i++) {
                        for (int k = 1; k <= n; k++) {
                            if (k <= n - i) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }

                    break;


                default:
                    System.out.println("Không có trong danh sách chọn!");
                    System.out.println("chon lai :");
                    break;


            }
            chose = scanner.nextInt();

        } while (chose != 4);

    }
}
