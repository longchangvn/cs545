package cs545.labs.lab4.repository;

import cs545.labs.lab4.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository2 extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(String author);
    List<Post> findByTitleContains(String title);
}
