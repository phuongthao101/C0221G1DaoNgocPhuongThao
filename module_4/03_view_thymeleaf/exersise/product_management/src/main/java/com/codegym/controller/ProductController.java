package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";

    }
    @PostMapping("/save")
    public  String save (Product product, RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Updated product information successfully!");
        return "redirect:/product/";
    }
    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String remove(Product product,RedirectAttributes redirect){
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product/";
    }
    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @GetMapping("/search")
    public String findProduct(@RequestParam String name,Model model){
        model.addAttribute("products",productService.findByName(name));
        return "/index";
    }
}


