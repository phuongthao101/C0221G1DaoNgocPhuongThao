package quan_ly_xe_co2.maincontroller;

import java.util.Scanner;

public class QuanLyChucNang {
    static Scanner scanner = new Scanner(System.in);
    static void xoaPhuongTien() {
       boolean kiemTra = true;
        do {
            System.out.println("THÊM MỚI PHƯƠNG TIỆN");


            System.out.println("1. Thêm xe tải,\n" +
                    " \t2. Thêm ôtô, \n" +
                    "3. Thêm  xe máy.\n" +
                    "4. Tro ve menu chinh\n" +
                    "5.Thoat");
            switch (scanner.nextInt()) {
                case 1:
                    themXeTai();
                    break;
                case 2:
                    themOto();
                    break;
                case 3:
                    themXeMay();
                    break;
                case 4:
                    DanhMuc.danhMuc();
                    break;
                case 5:
                    kiemTra = false;
                    break;

            }

        }while (kiemTra = true);
    }

    private static void themXeMay() {
        //String bienKiemSoat, String tenHSX, int namSX, String chuSoHuu, int taiTrong


    }

    private static void themOto() {

    }

    private static void themXeTai() {

    }

    static void hienThiPhuongTien() {

    }

    static void themPhuongTien() {

    }
}
