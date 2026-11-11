package com.varun.SpringBootWeb1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        System.out.println("Home Method Called");
        return "index.jsp";
    }
}
