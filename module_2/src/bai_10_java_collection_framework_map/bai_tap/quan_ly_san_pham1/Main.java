package bai_10_java_collection_framework_map.bai_tap.quan_ly_san_pham1;

import static bai_10_java_collection_framework_map.bai_tap.quan_ly_san_pham1.ProductManagement.*;

public class Main {

        public static void main(String[] args) {
            Product sanPham1 = new Product("Nokia", 1, 13000);
           Product sanPham2 = new Product("SamSum", 2, 8000);
           Product sanPham3 = new Product("  Oppo", 3, 5000);
            add(sanPham1);
            add(sanPham2);
            add(sanPham3);
            add(new Product("Bphone",4,1000));
            display();
            soft();
            remove(2);
            edit(1);
            display();


    }
}
