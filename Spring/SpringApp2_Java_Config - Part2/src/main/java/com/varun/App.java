package com.varun;

import com.varun.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);



        Alien obj = context.getBean(Alien.class);

        System.out.println(obj.getAge());
        obj.code();
    }
}
