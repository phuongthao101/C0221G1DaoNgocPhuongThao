package bai_3_array_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void minValue(int[] array) {
        int min = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j + 1;

            }
        }
        System.out.println("Giá trị nhỏ nhất là : " + min + " ,vị trí thứ " + index);
    }
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        minValue(arr);

    }
}