package quan_ly_xe_co2.maincontroller;

import java.util.Scanner;

public class DanhMuc {
    public static void main(String[] args) {
        danhMuc();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void danhMuc() {
        boolean kiemTra = true;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");


            System.out.println("Chọn các chức năng ");
            switch (scanner.nextInt()) {
                case 1:
                    QuanLyChucNang.themPhuongTien();
                    break;
                case 2:
                    QuanLyChucNang.hienThiPhuongTien();
                    break;
                case 3:
                    QuanLyChucNang.xoaPhuongTien();
                    break;
                case 4:
                    kiemTra = false;
                    break;

            }
        } while (kiemTra);
    }

}
