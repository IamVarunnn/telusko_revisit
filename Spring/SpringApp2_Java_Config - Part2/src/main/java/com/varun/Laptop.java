package com.varun;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Laptop Object Created");
    }

    public void compile(){
        System.out.println("Compiling using Laptop");
    }
}