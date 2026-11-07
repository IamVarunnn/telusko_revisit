package com.varun;

import com.varun.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Desktop desktop = context.getBean(Desktop.class);
        Desktop desktop1 = context.getBean(Desktop.class);
        desktop.compile();
        desktop1.compile();
    }
}
