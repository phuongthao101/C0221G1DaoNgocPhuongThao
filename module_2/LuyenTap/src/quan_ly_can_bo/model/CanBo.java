package quan_ly_can_bo.model;

public abstract class CanBo {
    protected String id;

    protected String hoTen;
    protected String namSinh;
    protected String gioiTinh;
    protected String diaChi;


    public CanBo(String id, String ten, String namSinh, String gioiTinh, String diaChi) {
        this.id = id;
        this.hoTen = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;

    }

    public CanBo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", id, hoTen, namSinh, gioiTinh, diaChi);
}
    public abstract void showInfo();
}
