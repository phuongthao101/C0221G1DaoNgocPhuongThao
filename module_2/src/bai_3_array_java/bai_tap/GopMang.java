package bai_3_array_java.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = new int [5];
        int[] array2 = new int [4];
        int[] array3 = new int [9];

        int i =0;
        while (i < array1.length) {
            System.out.print("Nhập phẩn tử mảng A" + (i + 1) + " : ");
            array1[i] = scanner.nextInt();
            i++;
        }
        int j = 0;
        while (j < array2.length) {
            System.out.print("Nhập phần tử mảng B" + (j + 1) + " : ");
            array2[j] = scanner.nextInt();
            j++;
        }
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        for ( i= 0; i<array1.length ; i++){
            array3[i] = array1[i];
        }
        for ( i = 0; i <array2.length ; i++){
            array3[array1.length + i ]  = array2[i];
        }
        System.out.println(Arrays.toString(array3));
    }


}
