package bai_3_array_java.bai_tap;

import java.util.Scanner;

public class GiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[8];
        int i =0;
        while (i < array.length) {
            System.out.print("Nhập phẩn tử mảng " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        int min = array[0];
        for( i = 2 ; i<array.length ; i++){
            if(array[i] <min){
                min = array[i];

            }
        }
        System.out.println("Phần tử nhỏ nhất trong mảng là :" + min);

    }
}
