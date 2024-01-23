package cs545.labs.lab5.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentRequestModel {
    private String comment;
    private Long postId;
}
