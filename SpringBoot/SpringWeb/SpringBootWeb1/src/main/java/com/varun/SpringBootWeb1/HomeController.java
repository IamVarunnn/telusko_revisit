package com.varun.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String home(){
        System.out.println("Home Method Called");
        return "index.jsp";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request){

        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));

        int res = n1 + n2;
        System.out.println(res);
        return "result.jsp";


    }
}
