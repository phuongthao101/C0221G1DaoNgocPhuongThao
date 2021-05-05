package quan_ly_xe_co2.common;

public class PhuongTienException extends Exception {

    public PhuongTienException(String message) {
        super(message);
    }
    public static void kiemTraBienKiemSoatOto(String bienKS) throws PhuongTienException{
        // XXY-XXX.XX (X : 0÷9 , Y=A nếu xe du lịch, Y=B  nếu xe khách)
        String regex ="^[0-9]{2}[A|B]-[0-9]{3}.[0-9]{2}$";
        if (!bienKS.matches(regex)){
            throw new PhuongTienException("nhap bien kiem soat theo mau : XXY-XXX.XX");
        }
    }

}
