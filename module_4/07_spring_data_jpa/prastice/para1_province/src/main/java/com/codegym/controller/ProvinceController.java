package com.codegym.controller;

import com.codegym.model.entity.Province;
import com.codegym.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"","/province"})
public class ProvinceController {
    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping(value = "")
    public String showListProvince(Model model) {
        model.addAttribute("province", iProvinceService.findAll());
        return "list-province";
    }

    @GetMapping(value = "/create-province")
    public String showFormCreate(Model model) {
        model.addAttribute("province", new Province());
        return "/create-province";

    }

    @PostMapping(value = "/create-province")
    public String createProvince(@ModelAttribute Province province) {
        this.iProvinceService.save(province);
        return "redirect:/province";
    }

    @GetMapping(value = "/edit-province")
    public String showFormEdit(@RequestParam Integer id, Model model) {
        model.addAttribute("province", this.iProvinceService.findById(id));
        return "/edit-province";
    }

    @PostMapping(value = "/edit-province")
    public String editProvince(@ModelAttribute Province province, Model model) {
        model.addAttribute("province", province);
        this.iProvinceService.save(province);
        model.addAttribute("msg", "Edit Successfully");
        return "redirect:/province";
    }

    @GetMapping("/delete-province")
    public String showDelete(@RequestParam Integer id, Model model) {
        model.addAttribute("province", this.iProvinceService.findById(id));
        return "/delete-province";

    }

    @PostMapping(value = "/delete-province")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.iProvinceService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete Success");
        return "redirect:/province";
    }
}
