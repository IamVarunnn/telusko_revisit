package com.varun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        Alien obj = (Alien) context.getBean("alien");
        Alien obj = context.getBean("alien", Alien.class);
//        obj.setAge(23);
        System.out.println(obj.getAge());
        obj.code();




//        Desktop desktop = (Desktop) context.getBean("com2");


    }
}
