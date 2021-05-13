package controller;

import common.FuncReadAndWriteFile;
import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);


    public static void showMenu() {

        while (true) {
            int choose = 0;

            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    showVehicle();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long chon tu 1-3");
            }
        }
    }

    private static void deleteVehicle() {
        String input = inputVehicle();

        List<Vehicle> vehicleList = FuncReadAndWriteFile.readFile("Vehi.csv");
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getPalate().equals(input)) {
                System.out.println("Ban co chac muon xoa: ");
                System.out.println(
                        "1. Co" + "\n" +
                                "2. Khong");
                while (true) {
                    String option = scanner.nextLine();
                    switch (option) {
                        case "1":
                            delete(vehicleList, i);
                            return;
                        case "2":
                            System.out.println("Ban khong xoa");
                            return;
                    }
                }

            }
        }

        System.out.println("Khong Tim Thay Ket Qua");
    }

    private static String inputVehicle() {
        System.out.println("Nhap bien kiem soat can xoa");
        String input = null;
        int count = 0;
        while (true) {
            input = scanner.nextLine();
            if (input.length() > 0) {
                break;
            } else {
                if (count > 0) {
                    System.out.println("Vui long nhap lai");
                }
            }
            count++;
        }

        return input;
    }
    private static void delete(List<Vehicle> list, int index) {
        list.remove(list.get(index));
        FuncReadAndWriteFile.writeFile("Vehi.csv", list, false);
        System.out.println("Da xoa thanh cong");
    }

    private static void showVehicle() {
        int choose = 0;
        while (true) {
            System.out.println("Hiern thi thong tin xe" + "\n" +
                    "1. Xe tai" + "\n" +
                    "2. Xe Oto" + "\n" +
                    "3. Xe may " + "\n" +
                    "4. Tat ca" + "\n" +
                    "5. Quay lai menu");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    showTruck();
                    break;
                case 2:
                    showCar();
                    break;
                case 3:
                    showBike();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showMenu();
                    break;
                default:
                    System.out.println("nhap tu 1-4");


            }
        }


    }

    private static void showAll() {

    }

    private static void showBike() {
        List<Vehicle> vehicleList = FuncReadAndWriteFile.readFile("Vehi.csv");
        for (Vehicle vehicles : vehicleList) {
            if (vehicles instanceof Bike) {
                vehicles.showInfo();
            }
        }

    }

    private static void showCar() {
        List<Vehicle> vehicleList = FuncReadAndWriteFile.readFile("Vehi.csv");
        for (Vehicle vehicles : vehicleList) {
            if (vehicles instanceof Car) {
                vehicles.showInfo();
            }
        }

    }

    private static void showTruck() {
        List<Vehicle> vehicleList = FuncReadAndWriteFile.readFile("Vehi.csv");
        for (Vehicle vehicles : vehicleList) {
            if (vehicles instanceof Truck) {
                vehicles.showInfo();
            }
        }

    }

    private static void addVehicle() {
        while (true) {
            int choose = 0;
            System.out.println("" +
                    "1. Thêm xe tải,\n" +
                    "2. Thêm ôtô, \n" +
                    "3. Thêm  xe máy.\n" +
                    "4. Quay lai menu chinh.\n");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addTruck();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    addBike();
                    break;
                case 4:
                    showMenu();
                    break;
                default:
                    System.out.println("vui long chon lai");
            }
        }

    }

    public static void addTruck() {
        //String palate, String nameProduction, int yearProduct, String owner, int weight
        String palateTruck = InputController.inputPalateTruck();
        String nameProduction = InputController.inputProduction();
        String yearProduct = InputController.inputYear();
        String owner = InputController.inputOwner();
        String weight = InputController.inputWeight();

        List<Vehicle> vehicleList = new ArrayList<>();

        Vehicle truck = new Truck(palateTruck, nameProduction, Integer.parseInt(yearProduct), owner, Integer.parseInt(weight));
        vehicleList.add(truck);
        FuncReadAndWriteFile.writeFile("Vehi.csv", vehicleList, true);

    }

    public static void addBike() {
        //palate, String nameProduction, int yearProduct, String owner, Double power
        String palateBike = InputController.inputPalateBike();


        System.out.println("Nhap hang san xuat");
        String nameProduction = scanner.nextLine();

        System.out.println("Nhap nam san xuat ");
        String yearProduct = scanner.nextLine();

        System.out.println("Nhap chu so huu ");
        String owner = scanner.nextLine();

        System.out.println("Nhap cong suat");
        Double power = scanner.nextDouble();


        List<Vehicle> vehicleList = new ArrayList<>();

        Vehicle bike = new Bike(palateBike, nameProduction, Integer.parseInt(yearProduct), owner, power);
        vehicleList.add(bike);
        FuncReadAndWriteFile.writeFile("Vehi.csv", vehicleList, true);
    }

    public static void addCar() {
        //String palate, String nameProduction, int yearProduct, String owner, String seat
        String palateCar = InputController.inputPalateCar();


        System.out.println("Nhap hang san xuat");
        String nameProduction = scanner.nextLine();

        System.out.println("Nhap nam san xuat ");
        String yearProduct = scanner.nextLine();

        System.out.println("Nhap chu so huu ");
        String owner = scanner.nextLine();

        System.out.println("Nhap loai xe");
        String type = scanner.nextLine();

        System.out.println("Nhap nam so cho ngoi ");
        String seat = scanner.nextLine();

        List<Vehicle> vehicleList = new ArrayList<>();

        Vehicle car = new Car(palateCar, nameProduction, Integer.parseInt(yearProduct), owner, seat, type);
        vehicleList.add(car);
        FuncReadAndWriteFile.writeFile("Vehi.csv", vehicleList, true);
    }

}
