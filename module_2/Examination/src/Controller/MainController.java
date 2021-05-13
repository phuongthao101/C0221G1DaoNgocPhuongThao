package Controller;

import Common.FuncReadAndWriteFile;
import Model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            int choose = 0;
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ DANH BA");
            System.out.println("1. Xem danh sách" + "\n" +
                    "2. Thêm mới" + "\n" +
                    "3. Cập nhật" + "\n" +
                    "4. Xóa" + "\n" +
                    "5. Tìm kiếm" + "\n" +
                    "6. Thoát " + "\n" +
                    "Chọn chức năng ");

            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    showPhone();
                    break;
                case 2:
                    addPhone();
                    break;
                case 3:
                    updatePhone();
                    break;
                case 4:
                    deletePhone();
                    break;
                case 5:
                    findPhone();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("chọn từ 1-5");
            }
        }

    }

    private static void findPhone() { // sửa sau 11/5
        boolean check = false;

        String findPhone = inputPhone();
        List<Phone> phoneList = FuncReadAndWriteFile.readFile("Phone.csv");

        for (Phone phone : phoneList) {

            if (phone.getPhone().contains(findPhone)) {
                phone.toString();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Không tìm thấy sdt ");
        }
    }


    private static void deletePhone() {
        String input = inputPhone();
        List<Phone> phoneList = FuncReadAndWriteFile.readFile("Phone.csv");
        for (int i = 0; i < phoneList.size(); i++) {

            if (phoneList.get(i).getPhone().equals(input)) {

                while (true) {
                    System.out.println("Ban co chac muon xoa: ");
                    System.out.println(
                            "1. Co" + "\n" +
                                    "2. Khong");
                    while (true) {
                        String option = scanner.nextLine();
                        switch (option) {
                            case "1":
                                phoneList.remove(phoneList.get(i));
                                FuncReadAndWriteFile.writeFile("Phone.csv", phoneList, false);
                                return;
                            case "2":
                                System.out.println("Ban khong xoa");
                                return;
                        }

                    }

                }


            }
        }
        System.out.println("Không tìm thấy kết quả");
    }

    private static String inputPhone() {
        System.out.println("Nhập sdt ");
        String input = null;
        int count = 0;

        while (true) {
            input = scanner.nextLine();
            if (input.length() > 0) {
                break;
            } else {
                if (count > 0) {
                    System.out.println("vui lòng nhap lại");
                }


            }
            count++;
        }
        return input;

    }

    private static void updatePhone() {
        boolean check = false;
        while (true) {
            System.out.println("Nhập số điện thoại cần sửa");
            String editPhone = scanner.nextLine();

            List<Phone> phoneList = FuncReadAndWriteFile.readFile("Phone.csv");
            for (int i = 0; i < phoneList.size(); i++) {
                if (editPhone.equals(phoneList.get(i).getPhone())) {

                    System.out.println("Nhập số điện thoại mới");
                    String newPhone = scanner.nextLine();

                    System.out.println("Nhập nhóm mới");
                    String newGroup = scanner.nextLine();

                    System.out.println("Nhập tên");
                    String name = scanner.nextLine();

                    System.out.println("Nhập giới tính ");
                    String gender = scanner.nextLine();

                    System.out.println("Nhập địa chỉ ");
                    String address = scanner.nextLine();

                    System.out.println("Nhập ngày sinh");
                    String birthday = scanner.nextLine();

                    System.out.println("Nhập email");
                    String email = scanner.nextLine();

                    phoneList.get(i).setPhone(newPhone);
                    phoneList.get(i).setGroup(newGroup);
                    phoneList.get(i).setName(name);
                    phoneList.get(i).setGender(gender);
                    phoneList.get(i).setAddress(address);
                    phoneList.get(i).setBirthday(birthday);
                    phoneList.get(i).setEmail(email);
                    System.out.println("đã cập nhật");

                    FuncReadAndWriteFile.writeFile("Phone.csv", phoneList, false);

                    check = true;
                    break;
                }

            }
            if (check == false) {
                System.out.println("KHông tim thấy sdt ");
                showMenu();
            }

        }
    }

    private static void addPhone() {
        String phone = InputController.inputPhone();
        scanner.nextLine();
        System.out.println("Nhập nhóm danh ba");
        String group = scanner.nextLine();

        System.out.println("Nhập tên");
        String name = scanner.nextLine();

        System.out.println("Nhập giới tính ");
        String gender = scanner.nextLine();

        System.out.println("Nhập địa chỉ ");
        String address = scanner.nextLine();

        System.out.println("Nhập ngày sinh");
        String birthday = scanner.nextLine();

        System.out.println("Nhập email");
        String email = scanner.nextLine();

        List<Phone> phoneList = new ArrayList<>();
        Phone phones = new Phone(phone, group, name, gender, address, birthday, email);
        phoneList.add(phones);

        FuncReadAndWriteFile.writeFile("Phone.csv", phoneList, true);

    }

    private static void showPhone() {
        List<Phone> phoneList = FuncReadAndWriteFile.readFile("Phone.csv");
        for (Phone phones : phoneList) {
            System.out.println(phones.toString());

        }

    }

}
