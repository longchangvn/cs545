package cs545.labs.lab4.services;

import cs545.labs.lab4.domain.Comment;
import cs545.labs.lab4.dto.CommentDto;
import cs545.labs.lab4.dto.CommentRequestModel;
import cs545.labs.lab4.repository.CommentRepo;
import cs545.labs.lab4.repository.PostRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    CommentRepo repo;
    @Autowired
    PostRepository2 postRepo;
    @Transactional
    public CommentDto add(CommentRequestModel model){
        var comment  = new Comment();
        comment.setComment(model.getComment());
        var post =postRepo.getReferenceById(model.getPostId());
        if(post ==  null){
            return null;
        }
        post.getComments().add(comment);
        postRepo.save(post);
        return new CommentDto(comment);
    }
}
