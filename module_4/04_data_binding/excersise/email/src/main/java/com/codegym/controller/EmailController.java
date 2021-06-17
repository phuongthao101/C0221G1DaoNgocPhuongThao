package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @GetMapping(value = "/mail")
    public String goMail(Model model) {
        model.addAttribute("mail", new Email());

        return "home";
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute Email email) {
        return new ModelAndView("show", "mail", email);
    }
}
