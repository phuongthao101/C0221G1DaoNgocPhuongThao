package bai_3_array_java.thuc_hanh;

import java.util.Scanner;

public class SoLuongSinhVien {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int size;
        int[] array;
        do{
            System.out.println("Nhập số lượng sinh viên:");
            size = scanner.nextInt();
            if(size >30){
                System.out.println("Vượt quá số sinh viên được nhập");

            }
        }
        while (size>30);
        array =  new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print(" Điểm của các học sinh là:" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }

        int count =0;
        for(i =0; i<array.length; i++){
            if(array[i] >= 5 && array[i] <=10){
                count++;
            }
        }
        System.out.println("Số lượng học sinh đạt là: " +count);


    }
}
