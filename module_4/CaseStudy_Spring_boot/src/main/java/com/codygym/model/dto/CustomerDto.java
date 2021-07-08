package com.codygym.model.dto;

import com.codygym.model.entity.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static sun.security.x509.InvalidityDateExtension.DATE;

public class CustomerDto implements Validator {
    public final String DATE="^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
    private Long customerId;
    private String customerNumber;
    @NotBlank(message = "Please input name")
    private String name;
    @NotBlank
    private String birthday;
    @NotBlank
    private String gender;
    @NotBlank
    private String idCard;
    @NotBlank
    private String phone;
    @Email
    private String email;

    private String address;
    private CustomerType customerType ;
    private boolean flag = true;

    public CustomerDto(){

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.customerNumber.matches("^KH-[0-9]{4}$")){
            errors.rejectValue("customerCode", "customerCode.format");
        }
        if (!customerDto.phone.matches("^[0][0-9]{9,11}$")){
            errors.rejectValue("customerPhone", "customerPhone.format");
        }
        if (!customerDto.birthday.matches("^[\\p{L} .'-]+$")){
            errors.rejectValue("customerBirthday", "customerBirthday.format");
        }
        if (!customerDto.idCard.matches(DATE)){
            errors.rejectValue("customerIdCard", "customerIdCard.format");
        }
        if (!customerDto.name.matches("^[\\p{L} .'-]+$")){
            errors.rejectValue("customerName", "customerName.format");
        }
    }

}
