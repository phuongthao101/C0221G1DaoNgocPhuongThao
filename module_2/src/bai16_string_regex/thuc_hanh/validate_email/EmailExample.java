package bai16_string_regex.thuc_hanh.validate_email;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*\\@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập email bạn muốn ");
        String email = input.nextLine();
        while (!Pattern.matches(REGEX_EMAIL, email)) {
            System.out.println("Nhâp lại");
            email = input.nextLine();
        }
        System.out.println("Email cua bạn là  = " + email);
        System.out.println("Nhập ACCount bạn muốn ");
        String account = input.nextLine();
        while (!Pattern.matches(ACCOUNT_REGEX,account)){
            System.out.println("Nhập lại ");
            account= input.nextLine();
        }
        System.out.println("ACCOUNT of you is : " + account);
    }
}
