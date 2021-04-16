package bai_10_java_collection_framework_map.bai_tap.quan_ly_san_pham1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManagement {
    static List<Product> sanPhams = new ArrayList<>();

    public static void add(Product sanPham) {
        sanPhams.add(sanPham);
    }


    public static void edit(int id) {
        for (Product sanPham : sanPhams) {
            if (sanPham.getId() == id) {
                sanPham.setId(1);
                sanPham.setName("Iphone");
                sanPham.setPrice(8000);
                return;
            }
        }

    }

    public static Product remove(int id) {
        for (Product sanPham : sanPhams) {
            if (sanPham.getId() == id) {
                sanPhams.remove(sanPham);
                return sanPham;
            }
        }

        return null;
    }

    public static void display() {
        System.out.println(" Danh sach cac san pham  : ");
        System.out.println("_____________________________________________");
        for (Product sanPham : sanPhams) {
            System.out.println(sanPham);
            System.out.println("_____________________________________________");

        }
    }

    public static void soft() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        };
        sanPhams.sort(comparator);
    }

}
