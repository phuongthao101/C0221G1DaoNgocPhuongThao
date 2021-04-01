package bai_2_loop.bai_tap;

import java.util.Scanner;

public class SoNguyenToNhoHon100 {
    public static boolean KiemTraSoNguyenTo(int number) {
        if (number < 2){
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hiển thị sổ nguyên tố nhỏ hơn 10");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(" Số nguyên tố nhỏ hơn" + n+" là : ");

        int i=2;
        while (i<n){
            if (KiemTraSoNguyenTo(i)){
                System.out.println(i+" ");
            }
            i++;
        }

    }
}



