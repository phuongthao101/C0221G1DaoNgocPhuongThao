package com.codygym.model.dto;

import com.codygym.model.entity.employee.Division;
import com.codygym.model.entity.employee.EducationDegree;
import com.codygym.model.entity.employee.Position;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class EmployeeDto implements Validator {
    private Long id;
    @NotBlank
    private String employeeName;
    @NotBlank
    private String employeeBirthday;
    @NotBlank
    private String employeeIdCard;
    @NotBlank
    @Min(1)
    private String employeeSalary;
    @NotBlank
    private String employeePhone;
    @Email
    private String employeeEmail;

    private String employeeAddress;

    private String username;
    private Position position;
    private Division division;
    private EducationDegree educationDegree;
    private boolean flag = true;

    public EmployeeDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (!employeeDto.employeePhone.matches("^(090|091|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$")){
            errors.rejectValue("phone", "phone.format");
        }
    }
}
