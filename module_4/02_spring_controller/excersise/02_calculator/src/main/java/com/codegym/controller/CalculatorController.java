package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import com.codegym.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @RequestMapping
    public String home() {
        return "/index";
    }

    @RequestMapping(value = "/calculator")
    public String calculator(@RequestParam double num1, double num2, String calculator, Model model) {
        String result = calculatorService.calculator(num1,num2,calculator);
        model.addAttribute("result",result);
        return "/index";
    }

}
