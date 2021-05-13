package quan_ly_xe_co.service;

import quan_ly_xe_co.controller.Main;
import quan_ly_xe_co.common.RegexValidate;
import quan_ly_xe_co.model.Bike;
import quan_ly_xe_co.model.Car;
import quan_ly_xe_co.model.Truck;
import quan_ly_xe_co.model.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add {

    static Scanner scanner = new Scanner(System.in);
    public static List<Bike> bikeList = new ArrayList<>();
    public static List<Car> carList = new ArrayList<>();
    public static List<Truck> truckList = new ArrayList<>();

    public static void addNewVehicle() {
        int choose = 0;
        System.out.println(
                "1. Thêm xe tải,\n" +
                        "2. Thêm ôtô, \n" +
                        "3. Thêm  xe máy.\n" + "4. Quay lại menu");
        System.out.println("Chọn phương tiện");
        choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {

            case 1:
                addNewTruck();
                break;
            case 2:
                addNewCar();
                break;
            case 3:
                addNewBike();
                break;
            case 4:
                Main.displayMenu();
                break;
            default:
                System.out.println(" Vui lòng nhập lại");

        }

    }

    private static void addNewBike() {

        System.out.println(" Nhập biển kiểm soát");
        String numberPalate = scanner.nextLine();
        while (!RegexValidate.checkNamePalateBike(numberPalate)) {
            System.out.println("Vui lòng nhập lại");
            numberPalate = scanner.nextLine();

        }

        System.out.println("Nhập năm sản xuất");
        int yearOfProduction = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập hãng sản xuất ");
        String production = scanner.nextLine();

        System.out.println("Nhập chủ sở hữu");
        String owner = scanner.nextLine();


            System.out.println("Nhập công suất ( xe máy )");
            int power = Integer.parseInt(scanner.nextLine());

            Bike newBike = new Bike(numberPalate, production, yearOfProduction, owner, power); // tạo đối tương
            bikeList.add(newBike); // thêm pthuc của dtuong car vào list



    }


    //------------------------------------------------------------------------------
    private static void addNewCar() {

        System.out.println(" Nhập biển kiểm soát");
        String numberPalate = scanner.nextLine();

        while (!RegexValidate.checkNamePalateCar(numberPalate)) {
            System.out.println(" Vui lòng nhâp lại");
            numberPalate = scanner.nextLine();
        }

        System.out.println("Nhập năm sản xuất");
        int yearOfProduction = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập hãng sản xuất ");
        String production = scanner.nextLine();

        System.out.println("Nhập chủ sở hữu");
        String owner = scanner.nextLine();

        System.out.println("Nhập số chỗ ngồi ( xe ô tô ");
        int numberOfSeat = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập kiểu xe (xe ô tô)");
        String typeOfCar = scanner.nextLine();



        Car newCar = new Car(numberPalate, production, yearOfProduction, owner, numberOfSeat, typeOfCar);
        carList.add(newCar);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Car.csv", true));
            for (Vehicle car : carList) {
                bufferedWriter.write(car.toString());
                bufferedWriter.append("\n");


            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        carList.clear();

    }


    //----------------------------------------------------------------------------------------------
    private static void addNewTruck() {
        System.out.println(" Nhập biển kiểm soát");
        String numberPalate = scanner.nextLine();
        while (!RegexValidate.checkNamePalateTruck(numberPalate)) {
            System.out.println("Vui lòng nhập lại");
            numberPalate = scanner.nextLine();
        }
        System.out.println("Nhập năm sản xuất");
        int yearOfProduction = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập hãng sản xuất ");
        String production = scanner.nextLine();

        System.out.println("Nhập chủ sở hữu");
        String owner = scanner.nextLine();

        System.out.println("Nhập tải trọng( xe tải)");
        int weight = Integer.parseInt(scanner.nextLine());

        Truck newTruck = new Truck(numberPalate, production, yearOfProduction, owner, weight);
        truckList.add(newTruck);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Truck.csv", true));
            for (Vehicle truck : truckList) {
                bufferedWriter.write(truck.toString());
                bufferedWriter.append("\n");

            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

