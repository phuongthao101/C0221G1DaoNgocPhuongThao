package bai11_searching_athorithm.thuc_hanh.do_phuc_tap;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
      int[] frequentChar = new int[255];
        for(int i = 0; i <inputString.length(); i++) {
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);/* Tăng giá trị tần suất */

        }
        int max = 0;
        char character = (char) 255; /* empty character */
        for (int j = 0; j < 255; j++) {
            if (frequentChar[j] > max) {
                max = frequentChar[j];
                character = (char) j;
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }

}
