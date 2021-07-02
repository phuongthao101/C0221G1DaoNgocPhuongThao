package com.example.ex_home.controller;

import com.example.ex_home.model.entity.Product;
import com.example.ex_home.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = {"/", "/product"})
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping(value = "")
    public String showListProduct(Model model, @PageableDefault(size = 2) Pageable pageable,// sô lương record
                                  @RequestParam Optional<String> keyword) {
        Page<Product> productList = this.productService.findByName(keyword.orElse(""), pageable);
        model.addAttribute("products", productList);
        model.addAttribute("keyword", keyword.orElse(""));
        return "/product/index";

    }
}
