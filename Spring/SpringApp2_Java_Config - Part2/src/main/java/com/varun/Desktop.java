package com.varun;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("com")
public class Desktop implements Computer{

    public Desktop(){
        System.out.println("Desktop Created");
    }

    public void compile(){
        System.out.println("Compiling using Desktop");
    }
}