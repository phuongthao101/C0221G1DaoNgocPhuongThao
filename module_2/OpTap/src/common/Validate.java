package common;

public class Validate extends Exception{
    public Validate(String message) {
        super(message);
    }

        public static void checkPalateCar( String input) throws Validate {
        String regex = "^[0-9]{2}[A-B]{1}-[0-9]{3}.[0-9]{2}$";
        if (input.matches(regex) == false){
            throw  new Validate("Nhap sai dinh dang");
        }

    }
    public static void checkPalateTruck (String input)throws Validate {
        String regex = "^[0-9]{2}C-[0-9]{3}.[0-9]{2}$";
        if (input.matches(regex) == false){
            throw  new Validate("Nhap sai dinh dang");
        }

    }

    public static void checkPalateBike (String input)throws Validate {
        String regex = "^[0-9]{2}-[A-Z0-9]{2}-[0-9]{3}.[0-9]{2}$";
        if (input.matches(regex) == false){
            throw  new Validate("Nhap sai dinh dang");
        }
    }
}
