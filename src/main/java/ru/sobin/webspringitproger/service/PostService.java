package ru.sobin.webspringitproger.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sobin.webspringitproger.models.Post;
import ru.sobin.webspringitproger.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return postRepository.existsById(id);
    }

    @Transactional
    public void addIncrementView(Post post) {
        postRepository.findByIdAndIncrementView(post.getViews() + 1, post.getId());
    }
}
