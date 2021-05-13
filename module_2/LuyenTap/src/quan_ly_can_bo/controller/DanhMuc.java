package quan_ly_can_bo.controller;

import java.util.Scanner;

import static quan_ly_can_bo.controller.QuanLyChucNang.*;

public class DanhMuc {
    static Scanner scanner = new Scanner(System.in);
    public static void danhMuc(){

        while (true){
           String chon;

            System.out.printf("1. Nhập thông tin mới cho cán bộ\n" +
                    "2.Tìm kiếm theo tên(tương đối)\n" +
                    "3. Sắp xếp theo tên.\n" +
                    "4. Xóa theo danh sách \n" +
                    "5. Hiển thị thông tin về danh sách các cán bộ\n" +
                    "6.  Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    themThongTinCanBo();
                    break;
                case "2":
                    timKiemTheoTen();
                    break;
                case "3":
                    sapXepTheoNamSinh();
                    break;
                case "4":
                    xoaTheoDanhSach();
                    break;
                case "5":
                    hienThiCanBo();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");

            }
        }

    }


}
