package ru.sobin.webspringitproger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @GetMapping
    public String blogMain(Model model) {
        return "blog-main";
    }
}
