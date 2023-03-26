package ru.sobin.webspringitproger.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.sobin.webspringitproger.models.Post;
import ru.sobin.webspringitproger.repository.PostRepository;

import javax.transaction.NotSupportedException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAllByRemove(false);
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

    public Post findById(Long id) {
        var post = postRepository.findPostByIdAndRemove(id, false).orElseThrow();
        post.setViews(post.getViews() + 1);
        postRepository.save(post);
        return post;
    }

    public boolean existsById(Long id) {
        return postRepository.existsPostByIdAndRemove(id, false);
    }

    @Transactional
    public void blogPostUpdate(Long id, String title, String anons, String fullText) {
        var post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        postRepository.save(post);
    }

    @Transactional
    public void blogDelete(Long id) {
        var post = postRepository.findPostByIdAndRemove(id, false).orElseThrow();
        post.setRemove(true);
        postRepository.save(post);
    }
}
