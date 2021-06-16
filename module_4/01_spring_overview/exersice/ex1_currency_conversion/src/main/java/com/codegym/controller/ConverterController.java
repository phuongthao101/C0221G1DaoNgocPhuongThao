package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping
    public String home(){
        return  "/home";
    }
    @PostMapping("a")
    public String convert(@RequestParam String rate , String usd , Model model){
        double result =Double.parseDouble(rate)*Double.parseDouble(usd);
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("result",result);

        return "/home";
    }
}
