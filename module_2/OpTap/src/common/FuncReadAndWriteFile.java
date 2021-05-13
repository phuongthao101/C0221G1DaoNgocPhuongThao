package common;

import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;
import sun.text.bidi.BidiLine;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FuncReadAndWriteFile {
    public static final String PATH = "src/data/"; // từ khóa final

    public static void writeFile(String fileName, List<Vehicle> vehicleList, boolean writeStatus) {
        File file = new File(PATH + fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, writeStatus);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Vehicle vehicle : vehicleList) {
                bufferedWriter.write(vehicle.toString());
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

    public static List<Vehicle> readFile(String fileName) {
        File file = new File(PATH + fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        List<Vehicle> vehicleList = new ArrayList<>();
        String[] strings = null;
        String line = null;

        try {
            file = new File(PATH);

            if (!file.exists()) {
                file.createNewFile();
            }
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);


            while ((line = bufferedReader.readLine()) != null) {strings = line.split(",");
                if (line.length() == 0) {
                    continue;
                }
                       // cac phan tu trong mang ngan cach bang dau phay
                int type = Integer.parseInt(strings[4]);

                if (type == 1) {
                    Vehicle truck = new Truck(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3], Integer.parseInt(strings[5]));
                    vehicleList.add(truck);

                } else if (type == 2) {
                    Vehicle bike = new Bike(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3], Double.parseDouble(strings[5]));
                    vehicleList.add(bike);

                } else {
                    Vehicle car = new Car(strings[0], strings[1], Integer.parseInt(strings[2]), strings[3], strings[5], strings[6]);
                    vehicleList.add(car);

                }
            }


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
        return vehicleList;
    }
}