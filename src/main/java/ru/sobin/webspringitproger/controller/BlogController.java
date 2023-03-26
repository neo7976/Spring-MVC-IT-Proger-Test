package ru.sobin.webspringitproger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sobin.webspringitproger.models.Post;
import ru.sobin.webspringitproger.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    PostService postService;

    @GetMapping
    public String blogMain(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/add")
    public String blogPostAdd(@RequestParam("title") String title,
                              @RequestParam("anons") String anons,
                              @RequestParam("full_text") String fullText,
                              Model model) {
        postService.blogPostAdd(title, anons, fullText);
        //переадресовываем на другую страницу
        return "redirect:/blog";
    }

    @GetMapping("/{id}")
    public String getBlogDetailsById(@PathVariable("id") Long id, Model model) {
        if(!postService.existsById(id)) {
           return "redirect:/blog";
        }
        List<Post> list = new ArrayList<>();
        var post = postService.findById(id);
        post.ifPresent(list::add);
        model.addAttribute("post", list);
        return "blog-details";
    }
}
