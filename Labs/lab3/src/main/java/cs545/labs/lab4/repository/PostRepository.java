package cs545.labs.lab4.repository;

import cs545.labs.lab4.domain.Post;
import cs545.labs.lab4.dto.PostDto;
import cs545.labs.lab4.dto.PostRequestModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private static ArrayList<Post> posts = new ArrayList<>();
    private static int currentId = 1;

    public PostDto getById(long id) {
        var post = posts.stream().filter(p->p.getId()==id).findFirst();
        if(post.isEmpty()){
            return null;
        }
        return new PostDto(post.get());
    }

    public List<PostDto> getAll() {
        return posts.stream().map(p->new PostDto(p)).toList();
    }

    public PostDto add(PostRequestModel model) {
        model.setId(currentId++);
        var post = new Post(model);
        posts.add(post);
        return new PostDto(post);
    }

    public PostDto update(long id, PostRequestModel model) {

        var post = posts.stream().filter(p->p.getId() == id).findFirst();
        if(post.isEmpty()){
            return null;

        }
        var tmpPost = new Post(model);
        posts.remove(post.get());
        posts.add(tmpPost);
        return new PostDto(tmpPost);
    }

    public Boolean delete(long id) {

        var post = posts.stream().filter(p->p.getId() == id).findFirst();
        if(post.isEmpty()){
            return false;
        }
        posts.remove(post.get());
        return true;
    }

    public List<PostDto> SearchByAuthorName(String author) {

        var result = posts.stream().filter(p->p.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .map(r->new PostDto(r))
                .toList();
        return result;
    }
}
