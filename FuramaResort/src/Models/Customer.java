package Models;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private static ArrayList<Villa> listVilla=new ArrayList<>();
    private static ArrayList<House> listHouse=new ArrayList<>();
    private static ArrayList<Room> listRoom=new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    private String nameOfCustomer;
    private String dateOfBirth;
    private String gender;
    private int cmnd;
    private double phoneNumber;
    private String typeOfCustomer;
    private String email;
    private String address;
    private Services services;

    public Customer(String nameOfCustomer, String dateOfBirth, String gender, int cmnd, float phoneNumber, String typeOfCustomer, String email, String address, Services services) {
        this.nameOfCustomer = nameOfCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.typeOfCustomer = typeOfCustomer;
        this.email = email;
        this.address = address;
        this.services = services;
    }

    public Customer() {

    }

    public static ArrayList<Villa> getListVilla() {
        return listVilla;
    }

    public static void setListVilla(ArrayList<Villa> listVilla) {
        Customer.listVilla = listVilla;
    }

    public static ArrayList<House> getListHouse() {
        return listHouse;
    }

    public static void setListHouse(ArrayList<House> listHouse) {
        Customer.listHouse = listHouse;
    }

    public static ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public static void setListRoom(ArrayList<Room> listRoom) {
        Customer.listRoom = listRoom;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Customer.scanner = scanner;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(float phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void addNewCustomer(){

    System.out.println("Enter name: ");
    String name = scanner.nextLine();
    System.out.println("Enter Date of Birth: ");
    String dateOfBirth = scanner.nextLine();
    System.out.println("Enter Gender: ");
    String gender = scanner.nextLine();
    System.out.println("Enter Number of identity Card: ");
    String number = scanner.nextLine();
    System.out.println("Enter phone number: ");
    String phone = scanner.nextLine();
    System.out.println("Enter type of customer: ");
    String type = scanner.nextLine();
    System.out.println("Enter email: ");
    String email = scanner.nextLine();
    System.out.println("Enter address: ");
    String address = scanner.nextLine();
}


public void showInformationCustomers(){


}

}
