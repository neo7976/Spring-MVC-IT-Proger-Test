package ru.sobin.webspringitproger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sobin.webspringitproger.models.Post;
import ru.sobin.webspringitproger.service.PostService;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    PostService postService;

    @GetMapping
    public String blogMain(Model model) {
        Iterable<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
}
