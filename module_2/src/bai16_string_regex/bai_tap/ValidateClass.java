package bai16_string_regex.bai_tap;

import javax.swing.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static Pattern pattern;
    private Matcher matcher;
    public static final String CLASS_REGEX = "^[CAP]+[0-9]{4}+[GHIKLM]$";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập lớp:");

        String className = input.nextLine();

        while (!Pattern.matches(CLASS_REGEX, className)){
            System.out.println("Nhập lại");
            className = input.nextLine();
        }
        System.out.println("Tên lớp "+ className);
    }
}
