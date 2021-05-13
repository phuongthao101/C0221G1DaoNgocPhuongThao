package Commons;

import Models.Customer;
import Models.Services;
import Models.Villa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncReadWriteCustomer {

    public static final String PATH = "src/Data/";

    public static void writeFile(String fileName, List<Customer> customerList, boolean writeStatus) {
        File file = new File(PATH + fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, writeStatus);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customers : customerList) {
                bufferedWriter.write(customers.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Customer> readFile(String fileName) {
        File file = new File(PATH + fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Customer> customerList = new ArrayList<>();
        String[] strings = null;
        String line = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings = line.split(",");
            }
//            if (strings.length == 9) {
//                Customer customer = new Customer(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7], strings[8]);
//                customerList.add(customer);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

}

