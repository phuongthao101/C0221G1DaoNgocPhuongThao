package bai_10_java_collection_framework_map.bai_tap.quan_ly_san_pham2;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void inPut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập Tên Sản Phẩm ");
        name = scanner.nextLine();

        System.out.println("Nhập Giá Sản phẩm");
        price = Integer.parseInt(scanner.nextLine());
    }

}
