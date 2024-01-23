package cs545.labs.lab5.services;

import cs545.labs.lab5.domain.Post;
import cs545.labs.lab5.dto.PostDto;
import cs545.labs.lab5.dto.PostRequestModel;
import cs545.labs.lab5.repository.PostRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository2 repository;

    public PostDto getById(long id) {

        return new PostDto(repository.getReferenceById(id));
    }

    public List<PostDto> getAll() {

        return repository.findAll().stream().map(p -> new PostDto(p)).toList();
    }

    public PostDto add(PostRequestModel model) {
        var post = new Post();
        post.setAuthor(model.getAuthor());
        post.setContent(model.getContent());
        post.setTitle(model.getTitle());
        return new PostDto(repository.save(post));
    }

    public PostDto update(long id, PostRequestModel model) {
        var post = repository.getReferenceById(id);
        if (post == null)
            return null;
        post.setAuthor(model.getAuthor());
        post.setContent(model.getContent());
        post.setTitle(model.getTitle());
        return new PostDto(repository.save(post));
    }

    public Boolean delete(long id) {
        var post = repository.getReferenceById(id);
        if (post == null)
            return false;
        repository.delete(post);
        return true;
    }

    public List<PostDto> SearchByAuthorName(String author) {

        return repository.findByAuthor(author).stream().map(p->new PostDto(p)).toList();
    }

    public List<PostDto> findByTitle(String title) {

        return repository.findByTitleContains(title).stream().map(p->new PostDto(p)).toList();
    }
}
