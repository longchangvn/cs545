package cs545.labs.lab3.dto;

import cs545.labs.lab3.domain.Users;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private List<PostDto> posts = new ArrayList<>();
    public UserDto(Users user){
        id= user.getId();
        name = user.getName();

        posts = user.getPosts().stream().map(p-> new PostDto(p)).toList();
    }
    public UserDto(){}
}
