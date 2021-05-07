package Controllers;

import Commons.FuncReadAndWriteFile;

import Commons.FuncReadWriteCustomer;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    static Scanner scanner = new Scanner(System.in);

    public static void addNewBooking() {
        Scanner input = new Scanner(System.in);
        List<Customer> customers = FuncReadWriteCustomer.readFile("src\\Data\\Customer.csv");

        System.out.println("Sorting by NAME...");
        for(Customer element : customers){
            System.out.println(element.showInfor());
        }

        System.out.println("Which ID customer to make booking?");
        int numCustomer = Integer.parseInt(input.nextLine());
        Customer booking = customers.get(numCustomer-1);

        System.out.println("Which service to make booking?\n"
                +   "1.\tBooking Villa\n"
                +   "2.\tBooking House\n"
                +   "3.\tBooking Room\n");
        switch (input.nextLine()){
            case "1":
                List<Villa> villaList = ServiceController.showAllVilla();
                System.out.println(" Which ID VILLA to make booking?");
                Villa villa =  villaList.get(input.nextInt() -1 );
                booking.setServices(villa);
                break;
            case "2":
                List<House> houseList =  ServiceController.showAllHouse();
                System.out.println(" Which ID HOUSE to make booking?");
                House house = houseList.get(input.nextInt() -1 );
                booking.setServices(house);
                break;
            case "3":
                List<Room> roomList = ServiceController.showAllRoom();
                System.out.println(" Which ID HOUSE to make booking?");
                Room room = roomList.get(input.nextInt() -1 );
                booking.setServices(room);
                break;
        }
        List<Customer> bookingList =new ArrayList<>();
        bookingList.add(booking);
        FuncReadWriteCustomer.writeFile("src\\Data\\Booking.csv",bookingList,true);
        MainController.displayMainMenu();
    }
}
