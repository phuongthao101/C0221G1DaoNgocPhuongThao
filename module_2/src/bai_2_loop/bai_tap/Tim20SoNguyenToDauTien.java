package bai_2_loop.bai_tap;

import java.util.Scanner;

public class Tim20SoNguyenToDauTien {

    public static boolean KiemTraSoNguyenTo(int number) {
        if (number < 2) {
            return false;
        } else {
            int i = 2;
            for ( i = 2 ; i < number ; i++){
                if (number%i == 0 ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng muốn tìm ");
        int num = Integer.parseInt(input.nextLine());
        int count = 0 ;
        int i = 2 ;
        while (count < num){
            if (KiemTraSoNguyenTo(i)){
                System.out.println("Các số nguyên tố là " + i);
                count++ ;
            }
            i++ ;
        }
    }
}
