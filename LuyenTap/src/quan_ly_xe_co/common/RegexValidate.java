package quan_ly_xe_co.common;

import java.util.regex.Pattern;

public class RegexValidate {

public static boolean checkNamePalateTruck (String truck){
    String regex = "^[0-9]{2}C-[0-9]{3}.[0-9]{2}$";
    return Pattern.matches(regex,truck);

}
public static boolean checkNamePalateCar (String car){
    String regex = "^[0-9]{2}[A-B]{1}-[0-9]{3}.[0-9]{2}$";
    return  Pattern.matches(regex, car);
}
public static  boolean checkNamePalateBike (String bike){
    String regex = "^[0-9]{2}-[A-Z0-9]{2}-[0-9]{3}.[0-9]{2}$";
    return Pattern.matches(regex, bike);
}

}
