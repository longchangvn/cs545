package cs545.labs.lab1.domain;

import cs545.labs.lab1.dto.PostRequestModel;
import lombok.Data;

@Data
public class Post {
    long id;
    String title;
    String content;
    String author;

    public Post(long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Post(PostRequestModel model){
        this.id = model.getId();
        this.title = model.getTitle();
        this.content = model.getContent();
        this.author = model.getAuthor();
    }

}
