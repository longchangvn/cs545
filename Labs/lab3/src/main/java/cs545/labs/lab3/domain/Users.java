package cs545.labs.lab3.domain;

import cs545.labs.lab3.dto.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Post> posts = new ArrayList<>();

    public Users(UserRequest dto) {
        name = dto.getName();
        posts = dto.getPosts().stream().map(p ->
                {
                    var post = new Post();
                    post.setAuthor(p.getAuthor());
                    post.setTitle(p.getTitle());
                    post.setContent(p.getContent());
                    return post;
                }
        ).toList();
    }
}
