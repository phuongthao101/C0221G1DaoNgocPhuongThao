package com.codygym.controller;

import com.codygym.model.dto.CustomerDto;
import com.codygym.model.entity.customer.Customer;
import com.codygym.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/"})
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping(value = "create_customer")
    public String createCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "create_customer";
    }

    @PostMapping(value = "/save_customer")
    public String saveCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create_customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Create customer successfully");
        return "redirect:/list_customer";
    }
    @GetMapping (value = "list_customer")
    public String showListCustomer(Model model,
                                   @PageableDefault (size = 2)Pageable pageable,
                                   @RequestParam Optional<String> keyword){
        Page<Customer> customerList = customerService.findByName(keyword.orElse(""),pageable);
        model.addAttribute("customers" , customerList);
        model.addAttribute("keyword",keyword.orElse(""));
        return "list_customer";

    }



}
