package com.codygym.controller;

import com.codygym.model.dto.ContractDto;
import com.codygym.model.dto.ServiceDto;
import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.Contract;
import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.service.Services;
import com.codygym.model.service.IContractService;
import com.codygym.model.service.ICustomerService;
import com.codygym.model.service.IEmployeeService;
import com.codygym.model.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "contracts")
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IServiceService serviceService;

    @ModelAttribute(value = "customers")
    public Page<Customer> customerPage(Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @ModelAttribute(value = "employees")
    public Page<Employee> employeePage(Pageable pageable) {
        return employeeService.findAll(pageable);

    }

    @ModelAttribute(value = "services")
    Page<Services> servicesPage(Pageable pageable) {
        return serviceService.findAllService(pageable);
    }

    @GetMapping(value = "create")
    public String showCreateContract(Model model) {

        model.addAttribute("contractDto", new ContractDto());
        return "/contract/create";
    }

    @PostMapping(value = "save")
    public String saveService(@Valid @ModelAttribute("contractDto") ContractDto contractDto,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.contractService.save(contract);
        return "contract/create";

    }

}
