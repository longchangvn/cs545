package cs545.labs.lab3.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private List<PostDto> posts= new ArrayList<>();
}
