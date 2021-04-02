package bai_3_array_java.bai_tap;


import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        System.out.println(Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cần thêm");
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vị trí cần thêm vào:");
        int index = Integer.parseInt(scanner.nextLine());
        if( index <= 1  || index >= array.length -1){
         System.out.println("Không chèn được phần tử vào mảng");

            }else {
            int arrayNew[] = new int[array.length + 1];
            for (int i = 0; i < arrayNew.length; i++) {
                if (i < index - 1) {
                    arrayNew[i] = array[i];
                } else if (i == index - 1) {
                    arrayNew[i] = k;
                } else {
                    arrayNew[i] = array[i - 1];
                }
            }
            System.out.println("Mảng mới là");
            for (int j = 0; j < array.length + 1; j++) {

                System.out.print(arrayNew[j] + "\t");
            }
        }
    }
}


