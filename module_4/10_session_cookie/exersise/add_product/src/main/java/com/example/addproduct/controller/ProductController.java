package com.example.addproduct.controller;



import com.example.addproduct.model.entity.Cart;
import com.example.addproduct.model.entity.Product;
import com.example.addproduct.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

//    @GetMapping("/add/{id}")
//    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) {
//            return "/view.error.404";
//        }
//        if (action.equals("show")) {
//            cart.addProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
//        cart.addProduct(productOptional.get());
//        return "redirect:/shop";
//    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, Model model) {
        Product productOptional = productService.findById(id).get();
        if (productOptional == null ) {
            return "/view.error.404";
        }
        cart.addProduct(productOptional);
        model.addAttribute("msg", "Đã thêm sản phẩm vào giỏ hàng!!!");
        model.addAttribute("product",productOptional);
        return "view";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Long id, @ModelAttribute Cart cart,
                              Model model) {
        Product productOptional = productService.findById(id).get();
        if (productOptional == null ) {
            return "/view.error.404";
        }
        model.addAttribute("product",productOptional);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute Cart cart){
        Product product = productService.findById(id).get();
        if (product == null ) {
            return "/view.error.404";
        }
        cart.removeProduct(product);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/change/{id}")
    public String changeCountProduct(@PathVariable Long id,
                                     @ModelAttribute Cart cart,
                                     @RequestParam("action") String action){
        Product product = productService.findById(id).get();
        if (product == null ) {
            return "/view.error.404";
        }
        cart.changeCount(product,action);
        return "redirect:/shopping-cart";
    }
}
