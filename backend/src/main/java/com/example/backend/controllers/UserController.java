package com.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.UserRepo;
import com.example.backend.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    
    @PostMapping("/login")
    public User login(@RequestBody User entity) {
        return new UserRepo().login(entity);
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User entity) {
        return new UserRepo().register(entity);
    }

    @PostMapping("/changePassword")
    public int changePassword(@RequestBody User entity) {
        return new UserRepo().changePassword(entity);
    }
    
}
