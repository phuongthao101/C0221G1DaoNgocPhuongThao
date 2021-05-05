package quan_ly_xe_co.service;

import quan_ly_xe_co.controller.Main;
import quan_ly_xe_co.model.Bike;
import quan_ly_xe_co.model.Car;
import quan_ly_xe_co.model.Truck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static quan_ly_xe_co.service.Add.*;

public class Show {


    public static void showVehicle() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Hiện thị xe tải.\n" +
                "2. Hiện thị ôtô. \n" +
                "3. Hiện  xe máy.\n" + "4. Thoát" + " \nChọn các phương tiện muốn hiển thị :");
        int choose = 0;
        choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                showTruck();
                break;
            case 2:
                showCar();
                break;
            case 3:
                showBike();
                break;
            case 4:
                Main.displayMenu();
                break;
            default:
                System.out.println(" Vui lòng nhập lại");

        }

    }

    private static void showCar() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Car.csv"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String list1[] = line.split(",");

                String namePalate = list1[0];
                String production = list1[1];
                int yearOfProduction = Integer.parseInt(list1[2]);
                String owner = list1[3];
                int numberOfSeat = Integer.parseInt(list1[4]);
                String typeOfCar = list1[5];

                carList.add(new Car(namePalate, production, yearOfProduction, owner, numberOfSeat, typeOfCar));

            }
            for (Car item : carList) {
                System.out.println(item.toString());
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static void showTruck() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Truck.csv"));
        String line = null;

        while ((line = bufferedReader.readLine() )!= null){

            String[] list2 = line.split(",");

            String numberPalate = list2[0];
            String production = list2[1]; 
            int yearOfProduction = Integer.parseInt(list2[2]);
            String owner = list2[3];
            int weight = Integer.parseInt(list2[4]);
            
          truckList.add(new Truck(numberPalate, production, yearOfProduction,  owner,  weight));
          for (Truck item : truckList){
              System.out.println(item.toString());
          }
          bufferedReader.close();
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void showBike() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Truck.csv"));
            String line = null;

            while ((line = bufferedReader.readLine() )!= null){

                String[] list2 = line.split(",");

                String numberPalate = list2[0];
                String production = list2[1];
                int yearOfProduction = Integer.parseInt(list2[2]);
                String owner = list2[3];
                int weight = Integer.parseInt(list2[4]);

                truckList.add(new Truck(numberPalate, production, yearOfProduction,  owner,  weight));
                for (Truck item : truckList){
                    System.out.println(item.toString());
                }
                bufferedReader.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
