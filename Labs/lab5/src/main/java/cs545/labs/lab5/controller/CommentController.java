package cs545.labs.lab5.controller;

import cs545.labs.lab5.dto.CommentRequestModel;
import cs545.labs.lab5.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService service;

    @PostMapping
    public ResponseEntity addComment(@RequestBody CommentRequestModel model){
        var comment = service.add(model);
        if(comment == null){
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return ResponseEntity.ok(comment);
    }

}
