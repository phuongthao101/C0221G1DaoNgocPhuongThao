package com.codygym.model.dto;

import com.codygym.model.entity.service.RentType;
import com.codygym.model.entity.service.ServiceType;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto implements Validator {
    private  Long id;
    private  String serviceName;
    @Pattern(regexp = "^DV-[0-9]{4}")
    private  String serviceCode;
    @Min(10)
    private int serviceArea;
    @Min(1)
    private double serviceCost;
    @Min(1)
    private int serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(10)
    @NotNull
    private  double poolArea;
    @Min(1)
    private int numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if (!serviceDto.serviceCode.matches("^(DV-)[0-9]{4}$")){
            errors.rejectValue("serviceCode", "Code.format");
        }
    }
}
