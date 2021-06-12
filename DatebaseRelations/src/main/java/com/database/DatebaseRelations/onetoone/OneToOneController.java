package com.database.DatebaseRelations.onetoone;

import com.database.DatebaseRelations.onetoone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class OneToOneController {


    @Autowired
    private OneToOneService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.finAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = service.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllUsers() {
        service.deleteAllUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * POST
     *
     * {
     *
     * 	"name":"saeed",
     * 	"email":"saeed@gmail.com",
     *
     * 		"userprofile":{
     * 		"phoneNumber":"0945342754",
     * 		"address":"iran",
     * 		"gender":"MALE",
     * 		"birthOfDate":"1891-03-26"
     *                }
     *
     * }
     *
     */
}
