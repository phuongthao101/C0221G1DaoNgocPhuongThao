package bai11_searching_athorithm.bai_tap.tim_kiem_nhi_phan_dung_de_quy;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int array[] = {0,1,3,4,6,7,8,9,10};
        int n = array.length;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao phan tu can tim kiem :  ");

        int x = scanner.nextInt();
        int result = ob.binarySearch(array, x, 0, n - 1);
        if (result == -1)
            System.out.println("Khong tim thay trong mang !");
        else
            System.out.println("phan tu " + x + " nam o vi tri index = " + result);
    }
}
