package bai_10_java_collection_framework_map.bai_tap.quan_ly_san_pham2;

import java.util.*;

public class ProductManager extends Product {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Product sp1 = new Product(1, "Iphone 5", 5000);
        Product sp2 = new Product(2, "Iphone 6", 6000);
        Product sp3 = new Product(3, "Iphone 7", 7000);
        Product sp4 = new Product(4, "Iphone 8", 8000);

        productList.add(sp1);
        productList.add(sp2);
        productList.add(sp3);
        productList.add(sp4);
        productList.size();
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            showMenu();
            System.out.println("Chọn việc bạn muốn");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    int n;
                    System.out.println("Nhập số sản phẩm cần thêm");
                    n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Product newsp = new Product();
                        newsp.inPut();
                        productList.add(newsp);
                    }
                    break;
                case 2:
                    System.out.println("DANH SÁCH SẢN PHẨM HIỆN CÓ ");
                    for (Product item : productList) {
                        System.out.println(item + " ,");
                    }
                    break;
                case 3:
                    System.out.println("Nhập Id sản phẩm bạn muốn sửa ");
                    int num = Integer.parseInt(scanner.nextLine());
                    Product productEdit = null;
                    for (Product product : productList) {
                        if (num == product.getId()) {
                            productEdit = product;
                        }
                    }
                    // System.out.println("Nhập Id mới "+ productEdit.setName(""););
                    if (productEdit == null) {
                        System.out.println("Không có sản phẩm bạn tìm");
                    } else {
                        System.out.println("Nhập ID mới");
                        int newId = Integer.parseInt(scanner.nextLine());
                        productEdit.setId(newId);

                        System.out.println("Nhập tên sản phẩm mới");
                        String newName = scanner.nextLine();
                        productEdit.setName(newName);

                        System.out.println("Nhập Giá sản phẩm :");
                        int newPrice = Integer.parseInt(scanner.nextLine());
                        productEdit.setPrice(newPrice);

                        System.out.println("đã update thành công");
                        break;
                    }
                case 4:
                    System.out.println("Chọn ID sản phẩm cần xóa");
                    int number = Integer.parseInt(scanner.nextLine());
                    boolean check = true;
                    for (Product item : productList) {
                        if (number == item.getId()) {
                            productList.remove(item);
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        System.out.println("Bạn nhập sai ");
                    }

                    break;
                case 5:
                    System.out.println("Nhập tên sản phẩm "); // tìm tên sp
                    String name = scanner.nextLine();

                    for (Product item : productList) {
                        if (name.equals(item.getName())) {
                            System.out.println(item.toString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Sắp xếp theo giá tăng dần");
                    productList.sort(Comparator.comparing(Product::getPrice));
                    break;
                case 7:
                    System.out.println("Sắp xếp Giảm dần ");
                    Collections.reverse(productList);
                    break;
                case 8:
                    System.out.println("Good bye");
                    break;
                default:
                    System.err.println("Nhập lại nhé ! Sai rồi");


            }

        } while (choose != 8);

    }

    static void showMenu() {
        System.out.println("1. Thêm SẢM PHẨM");
        System.out.println("2. HIỂN THỊ DANH SÁCH SẢN PHẨM");
        System.out.println("3. SỬA THÔNG TIN SẢN PHẨM ");
        System.out.println("4. XÓA SẢN PHẨM  ");
        System.out.println("5. TÌM KIẾM SẢN PHẨM THEO TÊN  ");
        System.out.println("6. TÌM KIẾM SẢN PHẨM THEO GIÁ TĂNG DẦN  ");
        System.out.println("7. TÌM KIẾM SẢN PHẨM THEO GIÁ GIẢM DẦN ");
        System.out.println("8. THOÁT");
    }
}
