package bai16_string_regex.bai_tap;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static Pattern pattern;
    public static final String PHONE_REGEX = "^[(][0-9]{2}[)][\\-][(][0][0-9]{9}[)]$";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập sdt:");

        String phoneNumber = input.nextLine();
        while (!Pattern.matches(PHONE_REGEX,phoneNumber)){
            System.out.println("Nhập lại");
            phoneNumber = input.nextLine();

        }
        System.out.println("Số dt là : " + phoneNumber);

    }
}
