package Common;

public class Validate extends Exception {
    public Validate(String message) {
        super(message);
    } // tạo ngoại le thông bao bằng dòng văn bản

    public static void checkPhone(String input) throws Validate {
        String regex = "^[0-9]{1}[0-9]{9}$";
        if (input.matches(regex) == false) {
            throw new Validate("Nhap sai dinh dang");
        }
    }
    public static void checkEmail(String input) throws Validate {
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*\\@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (input.matches(regex) == false) {
            throw new Validate("Nhap sai dinh dang");
        }
    }
}
