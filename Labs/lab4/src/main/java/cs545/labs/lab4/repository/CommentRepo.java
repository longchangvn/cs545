package cs545.labs.lab4.repository;

import cs545.labs.lab4.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
