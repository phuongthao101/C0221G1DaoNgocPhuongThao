package com.example.pra2_customer_phone.controller;

import com.example.pra2_customer_phone.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

public class PhoneController {
    @GetMapping(value = "")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index";

    }
    @PostMapping(value = "")
    public String checkValidation(@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber,
                                  BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasErrors()){
            return "index";
        }
        else {
            model.addAttribute("phoneNumber",phoneNumber);
            return "result";
        }
    }
}
