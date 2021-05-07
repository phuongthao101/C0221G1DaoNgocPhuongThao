package Controllers;

import java.util.Scanner;

import static Controllers.BookingController.addNewBooking;
import static Controllers.CustomerController.*;
import static Controllers.EmployeeController.showEmployee;
import static Controllers.ServiceController.*;



public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isBackToMenu;
    private static boolean isExit;

    public static void main(String[] args) {
        displayMainMenu();
    }

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
                    addNewServices();
                    break;
                case 2:
                   showServices();
                    break;
                case 3:
                    addNewCustomer();
                case 4:
                    showInformationOfCustomer();
                    break;

                case 5:
                    addNewBooking();

                    break;
                case 6:
                    showEmployee();
                    break;
                case 7:
                    isExit = true;
                    break;
                default:
                    System.out.println("Fail. Please choose number of menu exactly !");
                    break;

            }
            if(isExit){
                return;
            }
        }
            while (choose >= 1 && choose <= 7) ;
        }




}

