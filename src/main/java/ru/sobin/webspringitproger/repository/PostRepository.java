package ru.sobin.webspringitproger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.sobin.webspringitproger.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Modifying
//    @Query(value = "update spring_web_blog.post p set p.views=:views where p.id =:id", nativeQuery = true)
    @Query(value = "update Post p set p.views=:views where p.id =:id")
    void findByIdAndIncrementView(@Param("views") int views, @Param("id") long id);

    Optional<Post> findPostByIdAndRemove(Long id, boolean remove);

    List<Post> findAllByRemove(boolean remove);

    boolean existsPostByIdAndRemove(Long id, boolean remove);
}
