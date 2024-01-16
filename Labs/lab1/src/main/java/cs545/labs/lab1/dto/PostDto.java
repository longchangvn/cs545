package cs545.labs.lab1.dto;

import cs545.labs.lab1.domain.Post;
import lombok.Data;

@Data
public class PostDto {
    long id;
    String title;
    String content;
    String author;
    public PostDto(Post p){
        id = p.getId();
        title = p.getTitle();
        content = p.getContent();
        author = p.getAuthor();
    }
}
