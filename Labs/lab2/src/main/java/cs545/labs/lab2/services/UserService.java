package cs545.labs.lab2.services;

import cs545.labs.lab2.domain.Users;
import cs545.labs.lab2.dto.PostDto;
import cs545.labs.lab2.dto.UserDto;
import cs545.labs.lab2.dto.UserRequest;
import cs545.labs.lab2.repository.PostRepository2;
import cs545.labs.lab2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    PostRepository2 postRepo;

    @Transactional
    public UserDto AddUser(UserRequest model){
        var u = userRepo.save(new Users(model));
        return new UserDto(u);
    }
    @Transactional
    public List<UserDto> getAll(){
        return userRepo.findAll().stream().map(u-> new UserDto(u)).toList();
    }
    @Transactional
    public UserDto getById(Long id){
        var u = userRepo.getReferenceById(id);

        if(u==null)
            return null;
        return new UserDto(u);
    }
    @Transactional
    public List<PostDto> getAllPostByUser(Long userId){
        var u = userRepo.getReferenceById(userId);
        if(u==null)
            return null;
        return u.getPosts().stream().map(p-> new PostDto(p)).toList();
    }

    @Transactional
    public List<UserDto> getAllWithMoreThenPostCount(int count){
        var users = userRepo.findByPostsSizeGreaterThan(count);

        return users.stream().map(u-> new UserDto(u)).toList();
    }
}
