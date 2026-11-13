package com.varun.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String home(){
        System.out.println("Home Method Called");
        return "index";
    }

//    @RequestMapping("/add")
//    public String add(HttpServletRequest request, HttpSession session){
//
//        int n1 = Integer.parseInt(request.getParameter("num1"));
//        int n2 = Integer.parseInt(request.getParameter("num2"));
//
//        int res = n1 + n2;
//        session.setAttribute("result", res);
//        return "result.jsp";
//
//
//    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("num1")int num1, @RequestParam("num2") int num2, ModelAndView mv){


        int res = num1 + num2;
        mv.setViewName("result");
        mv.addObject(res);
        return mv;


    }
}
