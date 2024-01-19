package cs545.labs.lab4.domain;

import cs545.labs.lab4.dto.PostRequestModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    List<Comment> comments = new ArrayList<>();

    public Post(PostRequestModel model) {
        this.id = model.getId();
        this.title = model.getTitle();
        this.content = model.getContent();
        this.author = model.getAuthor();
    }

}
