package com.varun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){


        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Alien obj = (Alien) context.getBean("alien");
//        obj.code();
        obj.age = 29;
        System.out.println(obj.age);

        Alien obj1 = (Alien) context.getBean("alien");
//        obj1.code();
        System.out.println(obj1.age);



    }
}
