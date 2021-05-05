package quan_ly_xe_co.service;

import quan_ly_xe_co.controller.Main;
import quan_ly_xe_co.model.Bike;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static quan_ly_xe_co.service.Add.*;

public class Delete {
    public static Scanner scanner = new Scanner(System.in);

    public  static void deleteVehicle(){
        System.out.println(" Bạn muốn xóa phương tiện gì");
        System.out.println("1. Xe máy"+ "\n 2. Xe ô tô"+ " \n 3. Xe tải"+"4. Quay lại menu chính");
        int choose = Integer.parseInt(scanner.nextLine());

        switch (choose){
            case 1:
                deleteBike();
                break;
            case 2:
                deleteCar();
                break;
            case 3:
                deleteTruck();
                break;
            case 4:
                Main.displayMenu();
                break;
            default:
                System.out.println("Vui lòng nhập lại");


        }

    }

    private static void deleteTruck() {



    }



    private static void deleteCar() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Car.csv"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null ){
            String[] list3 = line.split(",");

        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void deleteBike() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Bike.csv"));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] list3 = line.split(",");
                String numberPalate = list3[0];
                String production = list3[1];
                int yearOfProduction = Integer.parseInt(list3[2]);
                String owner = list3[3];
                int power = Integer.parseInt(list3[4]);

                bikeList.add(new Bike(numberPalate, production, yearOfProduction, owner, power));
            }
                System.out.println(" Nhập biển kiểm soát cần xóa");
                String delete = scanner.nextLine();
                boolean check = false;
                for (int i = 0; i < bikeList.size() ; i++) {
                   if(delete.equals(bikeList.get(i).getNumberPalate())){
                        check = true;
                       System.out.println("Bạn có muốn xóa không");
                       System.out.println("1. Có"+ "\n 2. Không");
                       int choose = scanner.nextInt();

                       switch (choose){
                           case 1:
                               bikeList.remove(bikeList.get(i));
                               System.out.println(" Đã xóa thành công");
                               break;
                           case 2:
                               System.out.println("Bạn không muốn xóa");
                               break;
                       }

                   }
                }
                if( !check) {
                    System.out.println(" Không tìm thấy biển kiểm soát cần xóa");
                }



                bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // GHI LẠI FILE SAU KHI XÓA VÀO FILE GHI--------------------
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co\\data\\Bike.csv"));
            for (Bike item : bikeList){
                bufferedWriter.write(item.toString());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
