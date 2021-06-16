package com.codegym.controller;

import com.codegym.service.Impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/dictionary")
    public String result(@RequestParam String word, Model model) {

        model.addAttribute("resultFinal",""+ dictionaryService.find(word));
        return "result";
    }
}
