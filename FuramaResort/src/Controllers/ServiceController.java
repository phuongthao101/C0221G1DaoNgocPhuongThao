package Controllers;

import Commons.FuncReadAndWriteFile;
import Commons.InputService;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServiceController {

    private static Scanner scanner = new Scanner(System.in);

    public static List<Services> villas = new ArrayList();
    public static List<Services> houses = new ArrayList();
    public static List<Services> rooms = new ArrayList();

    public static void addNewServices() {
        while (true) {
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to Menu\n" +
                    "5.Exit");
            switch (scanner.nextLine()) {
                case "1":
                    addVilla();
                    break;
                case "2":
                    addHouse();
                    break;
                case "3":
                    addRoom();
                    break;
                case "4":
                    MainController.displayMainMenu();
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }

    private static void addRoom() {
        System.out.printf("Input Room");
        InputService.inputRoom();
        FuncReadAndWriteFile.writeFile("Room.csv", rooms, true);
    }

    private static void addHouse() {
        System.out.printf("Input House");
        InputService.inputHouse();
        FuncReadAndWriteFile.writeFile("House.csv", houses, true);
    }

    public static void addVilla() {
        System.out.printf("Input Villa");
        InputService.inputVilla();
        FuncReadAndWriteFile.writeFile("Villa.csv", villas, true);
    }

    public static void ShowInformationOfEmployee() {

    }

    public static void showInformationCustomers() {

    }

    public static void addNewBooking() {

    }

    public static void addNewCustomer() {
    }

    public static void showServices() {
        while (true) {
            System.out.println("" +
                    "1.Show all Villa\n" +
                    "2.Show all House\n" +
                    "3.Show all Room\n" +
                    "4.Show all Name Villa not Duplicate\n" +
                    "5.Show all Name House not Duplicate\n" +
                    "6.Show all Name Room not Duplicate\n" +
                    "7.Back to Menu\n" +
                    "8.Exit");
            switch (scanner.nextLine()) {
                case "1":
                    showAllVilla();
                    break;
                case "2":
                    showAllHouse();
                    break;
                case "3":
                    showAllRoom();
                    break;
                case "4":
                case "5":
                case "6":
                case "7":
                    MainController.displayMainMenu();
                    break;
                case "8":
                    System.exit(0);
            }
        }

    }

    public static void showAllVilla() {
        List<Services> list = FuncReadAndWriteFile.readWrite("Villa.csv");
        for (Services services : list) {
            System.out.println(services);
        }
    }

//    public static void showAllVillaIn1File(){
//        List<Services> list = FuncReadAndWriteFile.readWrite("src\\Data\\Service.csv");
//        for (Services services:list){
//            if (services instanceof Villa){
//                System.out.println(services);
//            }
//        }
//    }
//
    public static void showAllHouse() {
        List<Services> list = FuncReadAndWriteFile.readWrite("House.csv");
        for (Services services : list) {
            System.out.println(services);
        }
    }

    public static void showAllRoom() {
        List<Services> list = FuncReadAndWriteFile.readWrite("Room.csv");
        for (Services services : list) {
            System.out.println(services);
        }
    }

}
