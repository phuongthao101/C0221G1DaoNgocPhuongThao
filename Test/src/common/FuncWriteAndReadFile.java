package common;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncWriteAndReadFile {
    public static final String PATH = "D:\\C0221G1DaoNgocPhuongThao\\Test\\src\\data";

    public static void writeFile(String fileName, List<Product> list, boolean writeStatus) {
        File file = new File(PATH, fileName);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, writeStatus));
            for (Product product : list) {
                bufferedWriter.write(product.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error in writing");
            e.printStackTrace();
        }
    }

    public static List<Product> readFile(String fileName) {
        List<Product> list = new ArrayList<>();
        File file = new File(PATH, fileName);
        BufferedReader bufferedReader = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] temp;
            Product product = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                product = new Product(temp[0], temp[1], temp[2], temp[3]);
                list.add(product);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error in Reading");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  list;
    }

}
