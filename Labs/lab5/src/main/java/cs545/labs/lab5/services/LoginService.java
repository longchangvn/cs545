package cs545.labs.lab5.services;

import cs545.labs.lab5.config.JwtHelper;
import cs545.labs.lab5.config.UserDetailDto;
import cs545.labs.lab5.dto.LoginRequest;
import cs545.labs.lab5.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private  JwtHelper jwtHelper;

    public LoginResponse login(LoginRequest loginRequest) {
        var result = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        UserDetailDto user = (UserDetailDto) result.getPrincipal();
        var accessToken = jwtHelper.generateToken(user);
        var refreshToken = jwtHelper.generateRefreshToken(user);

        return new LoginResponse(accessToken, refreshToken);
    }

}
