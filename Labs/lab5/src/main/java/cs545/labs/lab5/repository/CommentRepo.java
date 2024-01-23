package cs545.labs.lab5.repository;

import cs545.labs.lab5.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
