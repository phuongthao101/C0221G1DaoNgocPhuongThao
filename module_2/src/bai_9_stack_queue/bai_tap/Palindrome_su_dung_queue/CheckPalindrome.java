package bai_9_stack_queue.bai_tap.Palindrome_su_dung_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Queue queue = new LinkedList();
        for (int i = inputString.length() - 1; i >= 0; i--) {
            queue.add(inputString.charAt(i));
        }
        String reverseString = "";
        while (!queue.isEmpty()) {
            reverseString = reverseString + queue.remove();

        }
        if (inputString.equals(reverseString)) {
            System.out.println("Đây là chuỗi đối xứng.");
        }else{
                System.out.println("Đây không phải là chuỗi đối xứng.");
            }
        }
    }

