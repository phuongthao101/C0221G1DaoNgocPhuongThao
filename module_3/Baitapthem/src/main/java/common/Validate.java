package common;

public class Validate {

    public static final String NAME = "[a-zA-Z\\s]+";
    public static String checkName(String name) {
        boolean check = name.matches(NAME);
        String checkName = "";
        if (!check) {
            checkName ="Invalid";
        }
        return checkName;
    }
}
