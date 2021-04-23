package bai14_iotext_file.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) throws  IOException {

        FileReader fileReader = new FileReader("src\\bai14_iotext_file\\thuc_hanh\\Reader.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int sum = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
            sum += Integer.parseInt(line);

        }
        bufferedReader.close();
        System.out.println("Tổng= " + sum);

    }
}
