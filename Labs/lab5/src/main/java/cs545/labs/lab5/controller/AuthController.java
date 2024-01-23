package cs545.labs.lab5.controller;

import cs545.labs.lab5.dto.LoginRequest;
import cs545.labs.lab5.dto.UserRequest;
import cs545.labs.lab5.services.LoginService;
import cs545.labs.lab5.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    LoginService service;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest model) {
        var response = service.login(model);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/registers")
    public ResponseEntity<?> register(@RequestBody UserRequest model) {
        return ResponseEntity.ok(userService.AddUser(model));
    }
}
