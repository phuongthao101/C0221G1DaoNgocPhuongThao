package Commons;

public class Vadidate {

    final static String ID_VILLA_REGEX = "^SVVL-[0-9]{4}$";
    final static String ID_HOUSE_REGEX = "^SVHO-[0-9]{4}$";
    final static String ID_ROOM_REGEX = "^SVRO-[0-9]{4}$";
    final static String SERVICE_NAME_REGEX = "^[A-Z][a-z]{1,}$";
    final static String AREA_REGEX = "^[1-9][0-9]{2,10}|[0][3-9][0-9]$";
    final static String COST_REGEX = "^[0-9][0]{6,}$";
    final static String PEOPLE_REGEX = "^[0-1][0-9]$";
    final static String FREE_SERVICE_REGEX = "^massage||karaoke||food||drink||car$";
    final static String FLOORS_REGEX = "^[0-9]{1,10}$";
    final static String RENT_REGEX = "^day|month|year$";
    final static String DAY_REGEX = "^([0-2][0-9]|30|31)[/]([0][1-9]|11|12)[/](19[0-9][1-9]|200[0-3])$";

    final static String CUSTOMER_NAME_REGEX = "^[A-Z][a-z]{1,}$";

}
