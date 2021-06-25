package com.example.form.controller;

import com.example.form.dto.UserDto;
import com.example.form.model.entity.User;
import com.example.form.model.service.IUserService;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller


public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(value = "/")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/index";

    }

    @PostMapping(value = "/sign-up")
    public String createUser(@Valid @ModelAttribute  UserDto userDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
    new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/index";
        }

    User user = new User();
        BeanUtils.copyProperties(userDto,user);
        this.userService.save(user);
        redirectAttributes.addFlashAttribute("msg","Create successfully");
        return "/result";

    }

}
