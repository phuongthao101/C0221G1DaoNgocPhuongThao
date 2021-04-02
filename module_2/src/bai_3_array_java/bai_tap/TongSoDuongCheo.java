package bai_3_array_java.bai_tap;

import java.util.Scanner;

public class TongSoDuongCheo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][3];
        int total1 = 0;
        int total2 = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println("Mảng " + i + ", " + j);
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if( i== j  ){
                    total1 += array[i][j];
                }
                if(j == array.length -i -1){
                    total2 += array[i][j];
                }

            }
        }
        int result = total1 +total2;
        System.out.println("Tổng đường chéo là :" + result);
    }
}

