package cs545.labs.lab5.dto;

import cs545.labs.lab5.domain.Users;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private List<PostDto> posts = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    public UserDto(Users user){
        id= user.getId();
        name = user.getName();
        posts = user.getPosts().stream().map(p-> new PostDto(p)).toList();
        roles = user.getRoles().stream().map(r->r.getName()).toList();

    }
    public UserDto(){}
}
