package bai_3_array_java.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {

    public static void main(String[] args) {
        Integer[] array = {2, 52, 6, 7, 9, 10};
        System.out.println(array);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xóa");

        int x = Integer.parseInt(scanner.nextLine());
       for( int i= 0; i<array.length; i++){
           if(array[i] == x){
               for ( int j = 0; j <array.length-1; j++){
                   array[j] = array[j] + 1;
               }
           }

       }
        System.out.println("Mảng mới sau khi xóa là" );
       for(int i=0; i<array.length; i++){
           System.out.println((array[i])+ " ");
       }

    }
}


