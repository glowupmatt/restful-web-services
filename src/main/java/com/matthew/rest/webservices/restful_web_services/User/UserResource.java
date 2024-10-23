package com.matthew.rest.webservices.restful_web_services.User;

import org.springframework.web.bind.annotation.RestController;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }
    
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        service.save(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
