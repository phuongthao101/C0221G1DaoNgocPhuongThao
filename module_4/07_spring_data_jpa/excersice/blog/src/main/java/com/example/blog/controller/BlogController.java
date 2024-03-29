package com.example.blog.controller;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

//    @RequestMapping(value = "")
//    public String goHome( Model model){
//        model.addAttribute("blog",iBlogService.findAll());
//        return "home";
//    }
    @RequestMapping(value = "")
    public ModelAndView goListBlog(@PageableDefault (size=2) Pageable pageable, @RequestParam Optional<String> keyword){
        String keywordValue="" ;
        if (keyword.isPresent()){
            keywordValue=keyword.get();
        }
        ModelAndView modelAndView = new ModelAndView("list-blog");
        Page<Blog> blogList =iBlogService.findAllByNameContaining(pageable,keywordValue);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }
    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute Blog blog){
        this.iBlogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog,Model model){
        this.iBlogService.save(blog);
        model.addAttribute("blog",blog);
        model.addAttribute("msg","Edit successfully");
        return "edit";
    }

    @GetMapping(value = "/show")
    public String showBlog(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "show";
    }
    @GetMapping(value = "/delete")
    public String showDelete(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        this.iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete Success");
        return "redirect:/blog";
    }
}
