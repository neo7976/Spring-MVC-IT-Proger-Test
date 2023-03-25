package ru.sobin.webspringitproger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sobin.webspringitproger.models.Post;
import ru.sobin.webspringitproger.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
