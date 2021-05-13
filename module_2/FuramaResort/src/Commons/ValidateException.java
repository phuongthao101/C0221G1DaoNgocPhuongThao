package Commons;

import com.sun.java.swing.plaf.windows.WindowsDesktopPaneUI;

public class ValidateException extends Exception {
    public ValidateException(String message) {
        super(message);
    }

    public static void checkId(String input) throws ValidateException {
        String regex = "^SVVL-[0-9]{4}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }

    }


    public static void checkNameService(String input) throws ValidateException {
        String regex = "^SVHO-[0-9]{4}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }

    }

    public static void checkArea(String input) throws ValidateException {
        String regex = "^[A-Z][a-z]{1,}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }

    public static void checkCost(String input) throws ValidateException {
        String regex = "^[0-9][0]{6,}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }
    public static void checkPeople(String input) throws ValidateException {
        String regex = "^[0-1][0-9]$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }

    public static void checkExtraService(String input) throws ValidateException {
        String regex = "^[massage]||[karaoke]||[food]||[drink]||[car]$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }
    public static void checkFloor(String input) throws ValidateException {
        String regex = "^[0-9]{1,10}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }
    public static void checkRent(String input) throws ValidateException {
        String regex = "^^SVHO-[0-9]{4}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }


    public static void checkCustomerName(String input) throws ValidateException {
        String regex = "^[A-Z][a-z]{1,}$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }
    //String nameOfCustomer, String dateOfBirth, String gender, int idCard,
    // float phoneNumber, String typeOfCustomer, String email, String address, Services services

    public static void checkidCard (String input) throws ValidateException {

            String regex = "^[0-9]{9}$";
            if (!input.matches(regex)) {
                throw new ValidateException("Fail, input again");
            }
        }
    public static void checkDay(String input) throws ValidateException {
        String regex = "^([0-2][0-9]|30|31)[/]([0][1-9]|11|12)[/](19[0-9][1-9]|200[0-3])$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }
    public static void checkEmail(String input) throws ValidateException {
        String regex = "^[A-Za-z0-9_]+@[A-Za-z0-9_]+\\\\.[A-Za-z0-9_]+$";
        if (!input.matches(regex)) {
            throw new ValidateException("Fail, input again");
        }
    }
    public static void checkNumber(String input) throws ValidateException {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)){
            throw new ValidateException("Fail, input again");
        }
    }

    }

