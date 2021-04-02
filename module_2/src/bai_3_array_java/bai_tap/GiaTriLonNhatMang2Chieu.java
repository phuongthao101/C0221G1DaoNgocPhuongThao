package bai_3_array_java.bai_tap;

import java.util.Scanner;

public class GiaTriLonNhatMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int [3][2];

        int max = array[0][0];
        for( int i=0; i< 3 ; i++){
            for(int j= 0; j < 2 ; j++){
                System.out.println("Mảng " + i + ", " + j);
                array[i][j] = scanner.nextInt();

                if(array[i][j] >max){
                    max = array[i][j];
                }
            }

        }

        System.out.println("Giá trị lớn nhất là " + max);
    }
}
