package com.varun.SpringSecurityApp1.controller;

import com.varun.SpringSecurityApp1.model.User;
import com.varun.SpringSecurityApp1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }
}
