package bai16_string_regex.thuc_hanh.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {

    public static final String ACCOUNT_REGEX= "^[a-z0-0_]{6,}$";

    public AccountExample(){

    }

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        String input = "abcabc12_";
        Matcher matcher = pattern.matcher(input);
        System.out.println(matcher.matches());
    }
}
