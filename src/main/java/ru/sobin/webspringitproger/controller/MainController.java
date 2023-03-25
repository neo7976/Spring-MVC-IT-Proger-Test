package ru.sobin.webspringitproger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String greeting(@RequestParam(name= "title", required=false, defaultValue="Главная страница") String name, Model model) {
//        model.addAttribute("name", name);
//        return "home";
//    }

    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

}