package bai15_binaryfile.bai_tap.quan_ly_san_pham;

import bai_10_java_collection_framework_map.bai_tap.quan_ly_san_pham1.ProductManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product {

    List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private int id;
    private String name;
    private String production;
    private double price;
    private String otherDescription;

    public Product(int id, String name, String production, double price, String otherDescription) {
        this.id = id;
        this.name = name;
        this.production = production;
        this.price = price;
        this.otherDescription = otherDescription;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", production='" + production + '\'' +
                ", price=" + price +
                ", otherDescription='" + otherDescription + '\'' +
                '}';
    }

    public void inPut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Tên Sản Phẩm ");
        name = scanner.nextLine();
        System.out.println("Nhập Hãng sản xuất");
        production = scanner.nextLine();
        System.out.println("Nhập Giá Sản phẩm");
        price = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả khác");
        otherDescription = scanner.nextLine();
    }

    public static void showMenu() {
        System.out.println("1. Thêm sản phẩm" + "\n 2. Hiển thị sản phẩm" +
                " \n 3. Tìm kiếm thông tin sản phẩm" + " \n 4. Exit ");
    }


}
