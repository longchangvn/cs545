package cs545.labs.lab3.repository;

import cs545.labs.lab3.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository2 extends JpaRepository<Post, Long> {

    List<Post> findByAuthor(String author);
    List<Post> findByTitleContains(String title);
}
