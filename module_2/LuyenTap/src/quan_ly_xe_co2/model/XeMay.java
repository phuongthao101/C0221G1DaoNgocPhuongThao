package quan_ly_xe_co2.model;

public class XeMay extends PhuongTien {
    private int congSuat;

    public XeMay() {
    }

    public XeMay(int congSuat) {
        this.congSuat = congSuat;
    }

    public XeMay(String bienKiemSoat, String tenHSX, int namSX, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, tenHSX, namSX, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String showInfor() {
        return "XeMay{" +
                "congSuat=" + congSuat +
                ", bienKiemSoat='" + bienKiemSoat + '\'' +
                ", tenHSX='" + tenHSX + '\'' +
                ", namSX=" + namSX +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + "," + congSuat;
    }
}