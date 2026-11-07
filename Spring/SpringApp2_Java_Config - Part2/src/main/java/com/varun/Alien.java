package com.varun;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {

    private int age;


    @Autowired
    @Qualifier("com" )
    private Computer com;

//    private Computer com;
//    @Autowired
//    Alien(@Qualifier("com") Computer com){
//        this.com = com;
//    }

    public Alien(){
        System.out.println("Alien Object Created");
    }

//    @ConstructorProperties({"age", "lap"})
//    public Alien(int age, Computer com){
//        this.age = age;
//        this.com = com;
//    }

    public int getAge() {
        return age;
    }

    @Value(value = "30")
    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("Coding");
        com.compile();
    }
}