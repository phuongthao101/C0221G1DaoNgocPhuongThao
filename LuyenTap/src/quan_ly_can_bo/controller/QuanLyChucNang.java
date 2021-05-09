package quan_ly_can_bo.controller;

import quan_ly_can_bo.common.DocGhiFile;
import quan_ly_can_bo.model.CanBo;
import quan_ly_can_bo.model.CongNhan;
import quan_ly_can_bo.model.KySu;
import quan_ly_can_bo.model.NhanVien;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyChucNang {
    static Scanner scanner = new Scanner(System.in);

    public static void themThongTinCanBo() {

        while (true) {
            String chon;
            System.out.printf(
                    "1. Them Cong Nhan\n" +
                            "2 Them Ky Su\n" +
                            "3 Them Nhan Vien\n" +
                            "4 Tro ve Danh Muc \n" +
                            "5 Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon) {
                case "1":
                    themCongNhan();
                    break;
                case "2":
                    themKySu();
                    break;
                case "3":
                    themNhanVien();
                    break;
                case "4":
                    DanhMuc.danhMuc();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.printf("Vui lòng chọn theo danh mục , từ 1-6");

            }

        }
    }

    public static void themCongNhan() {
        //ing id, String hoTen, String namSinh, String gioiTinh, String diaChi, String bac
        String id = QuanLyNhapLieu.nhapId();
        String hoTen = QuanLyNhapLieu.nhapHoTen();
        String namSinh = QuanLyNhapLieu.nhapNamSinh();
        String gioiTinh = QuanLyNhapLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapLieu.nhapDiaChi();
      String bac = QuanLyNhapLieu.nhapCapBac();

        List<CanBo> canBoList = new ArrayList<>();
        CanBo congNhan = new CongNhan(id, hoTen,namSinh,gioiTinh,diaChi,bac);
        canBoList.add(congNhan);
        DocGhiFile.ghiFile("CanBo.csv", canBoList, true);

    }

    public static void themKySu(){
        String id = QuanLyNhapLieu.nhapId();
        String hoTen = QuanLyNhapLieu.nhapHoTen();
        String namSinh = QuanLyNhapLieu.nhapNamSinh();
        String gioiTinh = QuanLyNhapLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapLieu.nhapDiaChi();
        String nganh = QuanLyNhapLieu.nganhDaoTao();

        List<CanBo> canBoList = new ArrayList<>();
        CanBo kySu = new KySu(id,hoTen,namSinh,gioiTinh,diaChi,nganh);
        canBoList.add(kySu);
        DocGhiFile.ghiFile("CanBo.csv",canBoList,true);
    }

    public static void themNhanVien() {
        String id = QuanLyNhapLieu.nhapId();
        String hoTen = QuanLyNhapLieu.nhapHoTen();
        String namSinh = QuanLyNhapLieu.nhapNamSinh();
        String gioiTinh = QuanLyNhapLieu.nhapGioiTinh();
        String diaChi = QuanLyNhapLieu.nhapDiaChi();
        String congViec = QuanLyNhapLieu.congViec();

        List<CanBo> canBoList = new ArrayList<>();
        CanBo nhanVien = new NhanVien(id,hoTen,namSinh,gioiTinh,diaChi,congViec);
        canBoList.add(nhanVien);
        DocGhiFile.ghiFile("CanBo.csv",canBoList,true);
    }

    public static void timKiemTheoTen(){
        String ten = null;
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");
        System.out.println("nhap vao ten can tim kiem");
        ten = scanner.nextLine();
        for (CanBo canBo : canBoList){
            if (canBo.getHoTen().contains(ten)){
                System.out.println(canBo);

            }
        }
    }
    public static void sapXepTheoNamSinh(){
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");
       canBoList.sort(Comparator.comparing(CanBo::getNamSinh));
       for (CanBo canBo : canBoList){
           canBo.showInfo();
       }
    }
    public static void xoaTheoDanhSach(){
        boolean kiemTra = false;
        int chon = 0;
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");

        while (true){
            for (int i=0 ;i< canBoList.size();i++){
                System.out.println((i+1)+" : "+canBoList.get(i));
            }
            System.out.println("Nhập cán bộ cần xóa");
            while (true){
                try{
                    chon = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (NumberFormatException e){
                    System.err.println("vui lòng nhập số");
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < canBoList.size(); i++){
                if(chon == i + 1){
                    canBoList.remove(i);
                    DocGhiFile.ghiFile("CanBo.csv", canBoList, false);
                    kiemTra = true;
                    break;

                }

            }
            if (kiemTra){
                break;
            }else {
                System.out.printf("Vui lòng xóa trong danh sách");
            }
        }
    }
    public static void hienThiCanBo(){
        String chon;
        while (true){
            System.out.println("Danh Muc:\n" +
                    "1 Hien Thi Cong Nhan\n" +
                    "2 Hien thi Ky Su\n" +
                    "3 Hien thi Nhan Vien\n" +
                    "4.Hien thi tat ca\n" +
                    "5. Tro ve Danh Muc \n" +
                    "6. Thoát khỏi chương trình.\n");
            chon = scanner.nextLine();
            switch (chon){
                case "1":
                    hienThiCongNhan();
                    break;
                case "2":
                    hienThiKySu();
                    break;
                case "3":
                    hienThiNhanVien();
                    break;
                case "4":
                    hienThiTatCa();
                    break;
                case "5":
                    return;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("vui long nhap theo danh muc , chon tu 1-6");
            }
        }
    }
    public static void hienThiCongNhan(){
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv"); // ghi 3 file , "CongNhan.csv"
        for (CanBo canBo : canBoList){
            if (canBo instanceof  CongNhan){
                canBo.showInfo();
            }
        }
    }
    public static void hienThiKySu(){
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");
        for (CanBo canBo : canBoList){
            if (canBo instanceof  KySu){
                canBo.showInfo();
            }
        }
    }
    public static void hienThiNhanVien(){
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");
        for (CanBo canBo : canBoList){
            if (canBo instanceof  NhanVien){
                canBo.showInfo();
            }
        }
    }
    public static void hienThiTatCa(){
        List<CanBo> canBoList = DocGhiFile.docFile("CanBo.csv");
        for (CanBo canBo : canBoList){
            canBo.showInfo();
        }
    }

}
