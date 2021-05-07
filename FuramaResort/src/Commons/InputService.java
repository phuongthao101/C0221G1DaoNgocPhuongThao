package Commons;

import Models.*;
import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static Controllers.CustomerController.customerList;

import static Controllers.ServiceController.*;
//Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ).
//-	Riêng Villa sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Diện tích hồ bơi, Số tầng.
//

public class InputService {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputId() {
        String id = null;
        while (true) {
            try {
                System.out.printf("Enter id");
                id = scanner.nextLine();
                ValidateException.checkId(id);
                return id;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputnameService() {
        String nameService = null;
        while (true) {
            try {
                System.out.printf("Enter name");
                nameService = scanner.nextLine();
                ValidateException.checkNameService(nameService);
                return nameService;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputAreaUse() {
        String areaUse = null;
        while (true) {
            try {
                System.out.printf("Enter area Use");
                areaUse = scanner.nextLine();
                ValidateException.checkArea(areaUse);
                return areaUse;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputRentalCost() {
        String rentalCost = null;
        while (true) {
            try {
                System.out.printf("Enter rentalCost");
                rentalCost = scanner.nextLine();
                ValidateException.checkCost(rentalCost);
                return rentalCost;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputPeople() {
        String peole = null;
        while (true) {
            try {
                System.out.println("Enter peole");
                peole = scanner.nextLine();
                ValidateException.checkPeople(peole);
                return peole;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputTypeOfRent() {
        String typeOfRent = null;
        while (true) {
            try {
                System.out.println("Enter TypeOfRent");
                typeOfRent = scanner.nextLine();
                ValidateException.checkRent(typeOfRent);
                return typeOfRent;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputExtraService() {
        String extraService = null;
        while (true) {
            try {
                System.out.println("Enter ExtraService");
                extraService = scanner.nextLine();
                ValidateException.checkExtraService(extraService);
                return extraService;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputStandardRoom() {
        String standardRoom = null;
        while (true) {
            try {
                System.out.printf("Enter Standard Room");
                standardRoom = scanner.nextLine();
                ValidateException.checkNameService(standardRoom);
                return standardRoom;


            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public static String inputDescription() {
        String description = null;
        System.out.println("Enter Description");
        description = scanner.nextLine();
        return description;
    }

    public static String inputFloors() {
        String floors = null;
        System.out.println("Enter floors");
        floors = scanner.nextLine();
        return floors;
    }

    public static String inputGender() {
        boolean check = false;
        String choose = null;
        String gender = null;
        while (true) {
            System.out.println("Choose gender " +
                    "\n 1. Man" + "\n2. Women");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    gender = "Men";
                    check = true;
                    break;
                case "2":
                    gender = "Women";
                    check = true;
                    break;
                default:
                    System.out.println("Please choose 1 or 2 ");

            }
            if (check) {
                break;
            }

        }
        return gender;
    }

    public static String inputIdCard() {
        String idCard = null;
        while (true) {
            try {
                System.out.println("Enter Id Card");
                idCard = scanner.nextLine();
                ValidateException.checkExtraService(idCard);
                return idCard;

            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputDay() {
        String day = null;
        while (true) {
            try {
                System.out.println("Enter Day");
                day = scanner.nextLine();
                ValidateException.checkExtraService(day);
                return day;

            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputEmail() {
        String email = null;
        while (true) {
            try {
                System.out.println("Enter email");
                email = scanner.nextLine();
                ValidateException.checkExtraService(email);
                return email;

            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String inputService() {
        String service = null;

        System.out.println("Enter service");
        service = scanner.nextLine();

        return service;

    }
    public static String inputPhone() {
        String phone = null;

        System.out.println("Enter phone");
        phone = scanner.nextLine();

        return phone;

    }
    public static String inputTypeCustomer() {
        String typeCustomer = null;

        System.out.println("Enter typeCustomer");
        typeCustomer = scanner.nextLine();

        return typeCustomer;

    }
    public static String inputAddress() {
        String address = null;

        System.out.println("Enter address");
        address = scanner.nextLine();

        return address;

    }
    public static String inputCustomerName() {
        String customerName = null;
        while (true) {
            try {
                System.out.println("Enter Customer name");
                customerName = scanner.nextLine();
                ValidateException.checkExtraService(customerName);
                return customerName;

            } catch (ValidateException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public static String inputLevel(){
        boolean check = false;
        String choose = null;
        String level = null;
        while (true){
            System.out.println("Chon trinh do cua nhan vien : \n" +
                    "1.Trung cấp\n" +
                    "2.Cao Đăng\n" +
                    "3.Đại học \n" +
                    "4.Sau đại học");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    level = "Trung cấp";
                    check = true;
                    break;
                case "2":
                    level = "Cao đẳng";
                    check = true;
                    break;
                case "3":
                    level = "Đại học";
                    check = true;
                    break;
                case "4":
                    level = "Sau đại học";
                    check = true;
                    break;

            }
            if (check){
                break;
            }else {
                System.out.println("vui long chon theo danh sach 1-4");
            }
        }
        return level;
    }
    public static String inputPosition(){
        boolean check = false;
        String choose = null;
        String positon = null;
        while (true){
            //Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giá đốc.
            System.out.println("Chon vi tri cua nhan vien : \n" +
                    "1.Lễ tân\n" +
                    "2.Phục vụ\n" +
                    "3.Chuyên viên \n" +
                    "4.Giám sát\n" +
                    "5.Quản lý\n" +
                    "6.Giám đốc");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    positon = "Lễ tân";
                    check = true;
                    break;
                case "2":
                    positon = "Phục vụ";
                    check = true;
                    break;
                case "3":
                    positon = "Chuyên viên";
                    check = true;
                    break;
                case "4":
                    positon = "Giám sát";
                    check = true;
                    break;
                case "5":
                    positon = "Quản lý";
                    check = true;
                    break;
                case "6":
                    positon = "Giám đốc";
                    check = true;
                    break;

            }
            if (check){
                break;
            }else {
                System.out.println("vui long chon theo danh sach 1-4");
            }
        }
        return positon;
    }
    public static String inputSalary(){
        String salary = null;
        while (true){
            try{
                System.out.println("nhap luong nhan vien");
                salary = scanner.nextLine();
                ValidateException.checkNumber(salary);
                break;
            }catch ( ValidateException e){
                System.err.println(e.getMessage());
            }
        }
        return salary;
    }

}

