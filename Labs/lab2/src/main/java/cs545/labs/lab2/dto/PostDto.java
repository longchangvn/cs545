package cs545.labs.lab2.dto;

import cs545.labs.lab2.domain.Post;
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
    public PostDto(){}
}
