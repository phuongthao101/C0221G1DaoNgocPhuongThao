package quan_ly_can_bo.controller;

import quan_ly_can_bo.common.CanBoException;
import quan_ly_can_bo.common.DocGhiFile;
import quan_ly_can_bo.model.CanBo;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class QuanLyNhapLieu {
    static Scanner scanner = new Scanner(System.in);

    //:  id(Tự tăng CB-001)  , Họ tên, năm sinh, giới tính, địa chỉ
    public static String nhapId() {
        String id = null;
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");
        if (canBoList.isEmpty()) {
            id = "CB-001";
        } else {
            id = "CB-00" + (canBoList.size() + 1);
        }
        return id;
    }

    public static String nhapHoTen() {
        String hoTen = null;
        while (true) {
            try {

                System.out.println("Họ và tên");
                hoTen = scanner.nextLine();
                CanBoException.kiemTraHoTen(hoTen);
                return hoTen;
            } catch (CanBoException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String nhapNamSinh() {
        String namSinh = null;
        while (true) {
            try {
                System.out.println("Nhập năm sinh");
                namSinh = scanner.nextLine();
                CanBoException.kiemTraNamSinh(namSinh);
                return namSinh;

            } catch (CanBoException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String nhapGioiTinh() {
        boolean kiemTra = false;
        String chon = null;
        String gioiTinh = null;
        while (true) {
            System.out.println("Chọn giới tính "+
            "\n 1. Nam" + "\n2. Nữ");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    gioiTinh = "Nam";
                    kiemTra = true;
                    break;
                case "2":
                    gioiTinh = "Nữ";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2");

            }
            if (kiemTra) {
                break;
            }

        }
        return gioiTinh;
    }

    public static String nhapDiaChi() {
        String diaChi = null;
        while (true) {
            try {
                System.out.println("nhap dia chi");
                diaChi = scanner.nextLine();
                CanBoException.kiemTraDiaChi(diaChi);
                return diaChi;
            } catch (CanBoException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String nhapCapBac() {
        String bac = null;
        while (true) {
            try {
                System.out.println("nhap cap bac");
                bac = scanner.nextLine();
                CanBoException.kiemTraCapBac(bac);
                return bac;
            } catch (CanBoException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String nganhDaoTao() {
        boolean kiemTra = false;
        int chon = 0;
        String nganh = null;
        while (true) {
            List<String> stringList = DocGhiFile.docFileNganhDaoTao("nganhDaoTao.csv");
            for (int i = 0; i < stringList.size(); i++) {
                System.out.println((i + 1) + " : " + stringList.get(i)); // chưa hiểu ( hiển thị danh sách ngành)


            }
            System.out.println("Chọn theo danh sách");
            while (true){
                try{
                    chon = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < stringList.size(); i++) {
                if (i == chon - 1) {
                    nganh = stringList.get(i).split(",")[1];
                    kiemTra = true;
                    break;


                }
            }
            if (kiemTra) {
                break;
            } else {
                System.out.println("vui long chon theo danh sach");
            }
        }
        return nganh;
    }

    public static String congViec() {
        String congViec = null;
        boolean kiemTra = false;
        String chon = null;
        while (true) {
            System.out.printf("Chon cong viec\n" +
                    "1.PV-Ngoài trời\n" +
                    "2.PV-Trong nhà");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    congViec = "PV-Ngoài trời";
                    kiemTra = true;
                    break;
                case "2":
                    congViec = "PV-Trong nhà";
                    kiemTra = true;
                    break;
                default:
                    System.out.println("vui long chon 1 hoac 2");
            }
            if (kiemTra) {
                break;
            }
        }
        return congViec;
    }

}


