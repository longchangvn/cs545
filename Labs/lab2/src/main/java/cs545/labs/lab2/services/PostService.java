package cs545.labs.lab2.services;

import cs545.labs.lab2.dto.PostDto;
import cs545.labs.lab2.dto.PostRequestModel;
import cs545.labs.lab2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public PostDto getById(long id) {
       return repository.getById(id);
    }

    public List<PostDto> getAll() {
        return repository.getAll( );
    }

    public PostDto add(PostRequestModel model) {
       return repository.add(model);
    }

    public PostDto update(long id, PostRequestModel model) {

        return repository.update(id,model);
    }

    public Boolean delete(long id) {

        return repository.delete(id);
    }
    public List<PostDto> SearchByAuthorName(String author) {

       return repository.SearchByAuthorName(author);
    }
}
