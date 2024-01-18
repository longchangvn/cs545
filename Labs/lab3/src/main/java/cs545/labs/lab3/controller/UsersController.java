package cs545.labs.lab3.controller;


import cs545.labs.lab3.dto.UserRequest;
import cs545.labs.lab3.services.PostService;
import cs545.labs.lab3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService service;

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<?> AddUser(@RequestBody UserRequest model) {

        return ResponseEntity.ok(service.AddUser(model));

    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var u = service.getById(id);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<?> getAllPostByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getAllPostByUser(userId));
    }

    @GetMapping("/params")
    public ResponseEntity<?> getAllWithMoreThen1Post(@RequestParam(value = "post-count", required = false) int postCount, @RequestParam(value = "post-title", required = false) String title) {
        if (postCount > 0)
            return ResponseEntity.ok(service.getAllWithMoreThenPostCount(postCount));
        else if (title != null && !title.isEmpty()) {

            return ResponseEntity.ok(service.findUserByPostTitle(title));
        } else {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @GetMapping("/{id}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> getUserPostCommentById(@PathVariable Long id, @PathVariable long postId, @PathVariable Long commentId) {
        var user = service.getById(id);
        var post = user.getPosts().stream().filter(p -> p.getId() == postId).findFirst();
        if (post.isEmpty())
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        var comment = post.get().getComments().stream().filter(c -> c.getId() == commentId).findFirst();
        if (comment.isEmpty()) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return ResponseEntity.ok(comment.get());
    }

    @GetMapping("/{id}/posts/{postId}/comments")
    public ResponseEntity<?> getUserPostComment(@PathVariable Long id, @PathVariable long postId) {
        var user = service.getById(id);
        var post = user.getPosts().stream().filter(p -> p.getId() == postId).findFirst();
        if (post.isEmpty())
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));

        return ResponseEntity.ok(post.get().getComments());
    }

    @GetMapping("/{userId}/posts/{postId}")
    public ResponseEntity<?> getuserPostById(@PathVariable Long userId, @PathVariable long postId) {
        var user = service.getById(userId);
        var post = user.getPosts().stream().filter(p -> p.getId() == postId).findFirst();
        if (post.isEmpty())
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));

        return ResponseEntity.ok(post.get());
    }


}
