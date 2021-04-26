package bai15_binaryfile.bai_tap.quan_ly_san_pham;

import bai15_binaryfile.coppy_file_nhi_phan.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        WriteFile<Product> writeFile = new WriteFile();
        writeFile.writeToFile("D:\\C0221G1DaoNgocPhuongThao\\module_2\\src\\bai15_binaryfile\\bai_tap\\quan_ly_san_pham\\test.csv", productList);
        System.out.println(writeFile. readFromFile("D:\\C0221G1DaoNgocPhuongThao\\module_2\\src\\bai15_binaryfile\\bai_tap\\quan_ly_san_pham",productList));

        Product.showMenu();
        int choose = 0;
        do {
            System.out.println(" Please choose option 1-3");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    System.out.println(" Please choose 1-3 ");
                    break;
            }
        } while (choose >= 1 && choose <= 3);

    }

    private static void searchProduct() {
        System.out.println(" Nhập vào sản phẩm cần tìm");
        String name = scanner.nextLine();
        for (Product item : productList){
            if(name.equals(item.getName())){
                System.out.println(item.toString());
            }

        }
    }

    private static void showProduct() {
        System.out.println("Hiển thị danh sách sản phẩm ");
        for ( Product item : productList){
            System.out.println(item + " ,");
        }

    }

    public static void addProduct() {

        int n = 0;
        System.out.println("Nhập số sản phẩm cần thêm");
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Product newSP = new Product();
            newSP.inPut();
            productList.add(newSP);

        }
    }
}
