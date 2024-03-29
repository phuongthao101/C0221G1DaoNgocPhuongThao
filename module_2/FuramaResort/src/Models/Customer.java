package Models;

import java.util.Scanner;

public class Customer {

    public static Scanner scanner = new Scanner(System.in);
    private String nameOfCustomer;
    private String dateOfBirth;
    private String gender;
    private int idCard;
    private double phoneNumber;
    private String typeOfCustomer;
    private String email;
    private String address;
    private Services services;


    public Customer(String nameOfCustomer, String dateOfBirth, String gender, int idCard, float phoneNumber, String typeOfCustomer, String email, String address, Services services) {
        this.nameOfCustomer = nameOfCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.typeOfCustomer = typeOfCustomer;
        this.email = email;
        this.address = address;
        this.services = services;
    }

    public Customer(String nameOfCustomer, String dateOfBirth, String gender, String idCard, String phoneNumber, String typeOfCustomer, String email, String address, String services) {

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

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
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

    @Override
    public String toString() {
        return
                nameOfCustomer +
                        "," + dateOfBirth +
                        "," + gender +
                        "," + idCard +
                        "," + phoneNumber +
                        "," + typeOfCustomer +
                        "," + email +
                        "," + address +
                        "," + services
                ;
    }

    public String showInfor() {
        return "Customer{" +
                "nameOfCustomer='" + nameOfCustomer + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard=" + idCard +
                ", phoneNumber=" + phoneNumber +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';

    }

}


