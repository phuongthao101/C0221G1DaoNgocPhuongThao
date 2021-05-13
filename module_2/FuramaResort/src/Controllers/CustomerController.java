package Controllers;

import Commons.FuncReadAndWriteFile;
import Commons.FuncReadWriteCustomer;
import Commons.InputService;
import Models.Customer;
import Models.Room;
import Models.Services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CustomerController {

    public static Scanner scanner = new Scanner(System.in);

    public static List<Customer> customerList = new ArrayList<>();

    public static void addNewCustomer() {
        //String nameOfCustomer, String dateOfBirth, String gender, int idCard,
        // float phoneNumber, String typeOfCustomer, String email, String address, Services services
        String nameCustomer = InputService.inputCustomerName();
        String birthday = InputService.inputDay();
        String gender = InputService.inputGender();
        String idCard = InputService.inputIdCard();
        String phone = InputService.inputPhone();
        String typeOfCustomer = InputService.inputTypeCustomer();
        String email = InputService.inputEmail();
        String address = InputService.inputAddress();
        String service = InputService.inputService();

        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer(nameCustomer, birthday,gender,idCard,phone,typeOfCustomer,email,address,service);
        customerList.add(customer);
        FuncReadWriteCustomer.writeFile("Customer.csv", customerList, true);


    }

    public static void showInformationOfCustomer(){
        List<Customer> list = FuncReadWriteCustomer.readFile("src\\Data\\Customer.csv");
        for (Customer customer : customerList) {
            if (customer instanceof Customer) {
                System.out.println(customer);
            }
        }
        customerList.sort(Comparator.comparing(Customer::getNameOfCustomer));
        for (Customer customer : customerList){
            customer.showInfor();
        }
    }
}