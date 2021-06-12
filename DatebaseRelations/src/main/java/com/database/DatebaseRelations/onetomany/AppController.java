package com.database.DatebaseRelations.onetomany;

import com.database.DatebaseRelations.onetomany.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AppService service;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = service.finAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        Post newPost = service.addPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllPosts() {
        service.deleteAllPosts();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * add
     * {
     *
     *     "title": "Developing with java",
     *     "description": "i am expert in Java yoohoooo :))))",
     *
     *         "comments": [
     *             {
     *             "text": "nice"
     *             },
     *
     *             {
     *              "text": "goodjob"
     *             },
     *
     *             {
     *             "text": "really?"
     *             }
     *
     *         ]
     * }
     *
     */

}
