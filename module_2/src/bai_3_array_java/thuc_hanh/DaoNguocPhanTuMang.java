package bai_3_array_java.thuc_hanh;

import java.util.Scanner;

public class DaoNguocPhanTuMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);//  tạo phần tử của mảng
        do {
            System.out.println("Nhập độ dài mảng");
            size = Integer.parseInt(scanner.nextLine());
            if (size > 20)
                System.out.println("Mảng quá 20 phần tử");
        }
        while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Nhập vào phần tử của mảng:" + (i + 1) + ":");
            array[i] = scanner.nextInt();
            i++;

        }
        System.out.println("Phần tử của mảng là:");

        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        for (int j = 0; j < array.length / 2; j++) { //Đảo ngược phần tử của mảng
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.println( "Đảo ngược mảng :" );
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }

}
