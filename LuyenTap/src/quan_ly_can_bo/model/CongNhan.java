package quan_ly_can_bo.model;

public class CongNhan extends CanBo {
    private String capBac;


    public CongNhan(String id, String ten, String namSinh, String gioiTinh, String diaChi, String capBac) {
        super(id, ten, namSinh, gioiTinh, diaChi);
        this.capBac = capBac;
    }

    public CongNhan(String capBac) {
        this.capBac = capBac;
    }


    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    @Override
    public void showInfo() {
        System.out.printf("CongNhan{" +
                "capBac='" + capBac + '\'' +
                ", id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}' +"\n");
    }


    @Override
    public String toString() {
        return
            String.format("%s,1,%s", super.toString(), capBac);

    }

}
