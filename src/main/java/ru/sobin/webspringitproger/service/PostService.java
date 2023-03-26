package ru.sobin.webspringitproger.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sobin.webspringitproger.models.Post;
import ru.sobin.webspringitproger.repository.PostRepository;

import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void blogPostAdd(String title, String anons, String fullText) {
        Post post = Post.builder()
                .title(title)
                .anons(anons)
                .fullText(fullText)
                .build();
        postRepository.save(post);
        log.info("Сохранили {} в БД", post.getTitle());
    }
}
