package com.codygym.model.dto;

import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.service.Services;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class ContractDto {
    private Long id;
    private String contractStartDate ;
    private String contractEndDate ;
    @Min(1)
    private String contractDeposit;
    @Min(1)
    private String contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Services services;

}
