package quan_ly_hoa_don;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static boolean isExit;
    private static Scanner scanner = new Scanner(System.in);
List<VNCustomer> vnCustomers = new ArrayList<>();


    public static void displayMenu() {
        int choose = 0;

        System.out.println(

                        " \n1. Thêm mới khách hàng.\n" +
                        "2. Hiện thị thông tin khách hàng\n" +
                        "3. Tìm kiếm khách hàng\n" +
                        "4. Thêm mới hóa đơn\n" +
                        "5. Chỉnh sửa hóa đơn\n" +
                        "6. Hiện thị thông  tin chi tiết hóa đơn\n" +
                        "7. Thoát\n");
        System.out.println(" Chọn các chức năng trên: ");
        choose = scanner.nextInt();
        do {
            displayMenu();
            switch (choose) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    showCustomer();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    addInvoice();
                    break;
                case 5:
                    fixInvoice();
                    break;
                case 6:
                    showInvoice();
                    break;
                case 7:
                    isExit = true;
                    System.out.println("Chọn lại chức năng ");
                    break;

            }
            if (isExit) {
                return;
            }
        } while (choose != 7);
    }

    public static void main(String[] args) {
        displayMenu();
    }


    private static void showInvoice() {

    }

    private static void fixInvoice() {

    }

    private static void addInvoice() {

    }

    private static void searchCustomer() {


    }

    private static void showCustomer() {

    }

    private static void addCustomer() {
        System.out.println("1. Thêm khách hàng VN,\n" +
                " \t2. Thêm khách hàng nước ngoài, \n"+"\n3.Thoát ");
        System.out.println(" Chọn khách hàng cần thêm mới");

        int choose = 0;
        choose = scanner.nextInt();
        switch (choose){

            case 1:
                System.out.println(" Nhập mã mới khách hàng:");
                int newId = scanner.nextInt();
                System.out.println("Nhập tên mới khách hàng :");
                String name = scanner.nextLine();
                System.out.println("");

               break;
            case 2:
                break;
            case 3:


                }

        }

    }

