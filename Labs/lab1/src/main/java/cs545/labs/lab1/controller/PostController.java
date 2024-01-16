package cs545.labs.lab1.controller;

import cs545.labs.lab1.dto.PostRequestModel;
import cs545.labs.lab1.services.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService service;

    @GetMapping
    public ResponseEntity<?> GetAllPosts(){
        return  ResponseEntity.ok( service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> GetPostById(@PathVariable long id){
        var p = service.getById(id);
        if(p==null)
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        return  ResponseEntity.ok(p );
    }

    @PostMapping
    public ResponseEntity<?> AddNewPost(@RequestBody PostRequestModel model){
        return  ResponseEntity.ok( service.add(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdatePost(@PathVariable long id,@RequestBody PostRequestModel model){
        return  ResponseEntity.ok( service.update(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable long id){
        return  ResponseEntity.ok( service.delete(id));
    }

    @GetMapping("/params")
    public ResponseEntity<?> searchByParam(@RequestParam("author") String author){
        return  ResponseEntity.ok( service.SearchByAuthorName(author));
    }
}
