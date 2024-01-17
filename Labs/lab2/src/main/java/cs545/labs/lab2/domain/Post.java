package cs545.labs.lab2.domain;

import cs545.labs.lab2.dto.PostRequestModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    long id;
    String title;
    String content;
    String author;


    public Post(PostRequestModel model){
        this.id = model.getId();
        this.title = model.getTitle();
        this.content = model.getContent();
        this.author = model.getAuthor();
    }

}
