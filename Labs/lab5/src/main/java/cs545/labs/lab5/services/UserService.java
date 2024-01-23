package cs545.labs.lab5.services;

import cs545.labs.lab5.domain.Role;
import cs545.labs.lab5.domain.Users;
import cs545.labs.lab5.dto.PostDto;
import cs545.labs.lab5.dto.UserDto;
import cs545.labs.lab5.dto.UserRequest;
import cs545.labs.lab5.repository.PostRepository2;
import cs545.labs.lab5.repository.RoleRepo;
import cs545.labs.lab5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    PostRepository2 postRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder encoder;
    @Transactional
    public UserDto AddUser(UserRequest model) {

        var u = new Users(model);
        u.setRoles(model.getRoles().stream().map(r -> {
            var role = roleRepo.findById(r);
            if (role.isEmpty()){
                role = Optional.of(roleRepo.save(new Role(r)));
            }

            return role.get();
        }).toList());
        u.setPassword(encoder.encode(model.getPassword()));
        userRepo.save(u);
        return new UserDto(u);
    }

    @Transactional
    public List<UserDto> getAll() {
        return userRepo.findAll().stream().map(u -> new UserDto(u)).toList();
    }

    @Transactional
    public UserDto getById(Long id) {
        var u = userRepo.getReferenceById(id);

        if (u == null)
            return null;
        return new UserDto(u);
    }

    @Transactional
    public List<PostDto> getAllPostByUser(Long userId) {
        var u = userRepo.getReferenceById(userId);
        if (u == null)
            return null;
        return u.getPosts().stream().map(p -> new PostDto(p)).toList();
    }

    @Transactional
    public List<UserDto> getAllWithMoreThenPostCount(int count) {
        var users = userRepo.findByPostsSizeGreaterThan(count);

        return users.stream().map(u -> new UserDto(u)).toList();
    }

    public List<UserDto> findUserByPostTitle(String title) {
        var users = userRepo.findByPostsTitleContaining(title);

        return users.stream().map(u -> new UserDto(u)).toList();
    }
}
