package Controller;

import Common.Validate;

import java.util.Scanner;

public class InputController {
    static Scanner scanner = new Scanner(System.in);

    public static String inputPhone() {
        String phone = null;

        while (true) {
            try {
                System.out.println("Nhập số điện thoai");
                phone = scanner.nextLine();
                Validate.checkPhone(phone);
                return phone;
            } catch (Validate validate) {
                validate.printStackTrace();
            }

        }

    }
    public static String inputEmail() {
        String email = null;

        while (true) {
            try {
                System.out.println("Nhập email");
                email = scanner.nextLine();
                Validate.checkEmail(email);
                return email;
            } catch (Validate validate) {
                validate.printStackTrace();
            }

        }

    }

}


