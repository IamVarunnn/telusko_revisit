package com.varun.SpringSecurityApp2.controller;

import com.varun.SpringSecurityApp2.model.User;
import com.varun.SpringSecurityApp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.save(user);

    }
}
