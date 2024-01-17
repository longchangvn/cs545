package cs545.labs.lab2.repository;

import cs545.labs.lab2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository2 extends JpaRepository<Post, Long> {
}
