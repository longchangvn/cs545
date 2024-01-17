package cs545.labs.lab2.controller;


import cs545.labs.lab2.dto.UserRequest;
import cs545.labs.lab2.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<?> AddUser(@RequestBody UserRequest model){

        return ResponseEntity.ok(service.AddUser(model));

    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>  getById(@PathVariable Long id){
        var u = service.getById(id);
       return ResponseEntity.ok(u);
    }
    @GetMapping("/{userId}/posts")
    public ResponseEntity<?> getAllPostByUser(@PathVariable Long userId){
        return ResponseEntity.ok(service.getAllPostByUser(userId));
    }

    @GetMapping("/params")
    public ResponseEntity<?> getAllWithMoreThen1Post(@RequestParam("post-count") int postCount){
        return ResponseEntity.ok(service.getAllWithMoreThenPostCount(postCount));
    }
}
