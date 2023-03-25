package ru.sobin.webspringitproger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sobin.webspringitproger.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
