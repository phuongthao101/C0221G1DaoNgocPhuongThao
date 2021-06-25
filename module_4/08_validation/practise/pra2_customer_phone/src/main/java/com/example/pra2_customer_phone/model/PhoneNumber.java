package com.example.pra2_customer_phone.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PhoneNumber implements Validator {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
PhoneNumber phoneNumber = (PhoneNumber) target ; // ép kiểu cho đối tượng
        String number = phoneNumber.getNumber(); // tạo biến number lấy dữ liệu từ classPhoneNumber
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");//gửi thông báo
        if (number.length()>11 || number.length() <10){
            errors.rejectValue("number","number.length");
        }
        if (!number.startsWith("0")){ // validate nếu ko phải bắt đầu là 0
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }

    }
}
