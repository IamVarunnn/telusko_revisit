package com.varun.SpringSecurityApp2.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "Hey Nothing here " + request.getSession().getId();
    }


    @GetMapping("/hello")
    public String greet(HttpServletRequest request){
        return "Hello Everyone " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "Nothing about it! " + request.getSession().getId();
    }
}
