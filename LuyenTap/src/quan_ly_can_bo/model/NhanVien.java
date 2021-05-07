package quan_ly_can_bo.model;

public class NhanVien extends CanBo {

    private String congViec;

    public NhanVien(String id, String ten, String namSinh, String gioiTinh, String diaChi, String congViec) {
        super(id, 3,ten, namSinh, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public NhanVien(String congViec) {
        this.congViec = congViec;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return super.toString()+"," + congViec
                ;
    }

    @Override
    public void showInfo() {
        System.out.printf("NhanVien{" +
                "congViec='" + congViec + '\'' +
                ", id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}');
    }
}
