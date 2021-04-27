package Controllers;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {

        int choose = 0;
        do {

            System.out.println("1.\t Add New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n");
            System.out.println("Please choose one option (1 - 6)");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                   addNewCustomer();

                case 4:
                   addNewBooking();
                    break;

                case 5:
                    showInformationCustomers();
                    break;
                case 6:
                    ShowInformationOfEmployee();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Fail. Please choose number of menu exactly !");
                    break;

            }
        }
            while (choose >= 1 && choose <= 7) ;
        }

    private static void ShowInformationOfEmployee() {

    }

    private static void showInformationCustomers() {

    }

    private static void addNewBooking() {

    }

    private static void addNewCustomer() {
    }



//--------------------------------------------------------------------------------------------

    public static void addNewServies() {
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "5.\tExit\n");
        System.out.println("Please choose one option below");
        switch (scanner.nextInt()) {
            case 1:
                addNewVilla();
                break;

            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.out.println("Fail!! Please choose again!");
                break;
        }


    }
    private static void addNewVilla() {

    }

    private static void addNewRoom() {

    }

    private static void addNewHouse() {

    }



    //-------------------------------------------------------------------------------------------------

    public static void showServices() {
        System.out.println("1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "8.\tExit\n");
        System.out.println("Please choose one option below");
        switch (scanner.nextInt()) {
            case 1:
               showVilla();
                break;
            case 2:
                showHouse();
                break;
            case 3:
               showRoom();
                break;
            case 4:

            case 5:
            case 6:
            case 7:
                displayMainMenu();
                break;
            case 8:
                break;

        }

    }

    private static void showRoom() {

    }

    private static void showHouse() {

    }

    private static void showVilla() {

    }


}

