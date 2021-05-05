package quan_ly_xe_co.controller;

import quan_ly_xe_co.service.Add;
import quan_ly_xe_co.service.Delete;
import quan_ly_xe_co.service.Show;

import java.util.Scanner;

public class Main {
 public static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {

        int choose = 0;
        System.out.println("Chọn chức năng:\n" +
                "1. Thêm mới phương tiện.\n" +
                "2. Hiện thị phương tiện\n" +
                "3. Xóa phương tiện\n" +
                "4. Thoát\n");
        System.out.println("Chọn chức năng từ 1-4:");

       while (true){
           choose = Integer.parseInt(scanner.nextLine());
           switch (choose) {
               case 1:
                   Add.addNewVehicle();
                   break;
               case 2:
                   Show.showVehicle();
                   break;
               case 3:
                   Delete.deleteVehicle();
                   break;
               case 4:
                  System.exit(0);
                  break;
               default:
                   System.out.println("Vui lòng chọn lại");
           }
       }

    }

    public static void main(String[] args) {
        while (true){
            displayMenu();

        }

    }

}
