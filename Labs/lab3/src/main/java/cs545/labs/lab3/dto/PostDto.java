package cs545.labs.lab3.dto;

import cs545.labs.lab3.domain.Comment;
import cs545.labs.lab3.domain.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostDto {
    long id;
    String title;
    String content;
    String author;

    List<Comment> comments = new ArrayList<>();
    public PostDto(Post p){
        id = p.getId();
        title = p.getTitle();
        content = p.getContent();
        author = p.getAuthor();
        comments = p.getComments();
    }
    public PostDto(){}
}
