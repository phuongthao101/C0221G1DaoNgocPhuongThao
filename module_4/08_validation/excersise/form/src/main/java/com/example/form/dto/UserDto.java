package com.example.form.dto;

import com.example.form.model.entity.User;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.*;

@Data
public class UserDto implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;
//  @Pattern(regexp = "^0[0-9]{9,10}$")
    private String phone;
    @Min(18)
    private String age;
    @Email
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (!userDto.phone.matches("^[0][0-9]{9,11}$")){
            errors.rejectValue("phone", "phone.format");
        }

    }
}
