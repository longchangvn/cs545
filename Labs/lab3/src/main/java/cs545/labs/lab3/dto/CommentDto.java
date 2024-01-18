package cs545.labs.lab3.dto;

import cs545.labs.lab3.domain.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private String comment;
    private Long id;

    public CommentDto(Comment comment) {
        id = comment.getId();
        this.comment = comment.getComment();
    }
}
