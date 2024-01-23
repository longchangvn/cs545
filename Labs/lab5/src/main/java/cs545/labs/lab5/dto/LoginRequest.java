package cs545.labs.lab5.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
