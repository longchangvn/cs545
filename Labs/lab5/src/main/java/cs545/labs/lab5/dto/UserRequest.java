package cs545.labs.lab5.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String password;
    private List<PostDto> posts= new ArrayList<>();
    private List<String> roles= new ArrayList<>();
}
