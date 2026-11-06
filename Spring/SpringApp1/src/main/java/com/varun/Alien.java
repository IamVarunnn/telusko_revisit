package com.varun;


import java.beans.ConstructorProperties;

public class Alien {

    private int age;
    private Laptop lap;

    Alien(){
        System.out.println("Object Created");
    }

//    public Alien(int age){
//        System.out.println("Para constructor called");
//        this.age = age;
//    }

    @ConstructorProperties({"age", "lap"})
    public Alien(int age, Laptop laptop){
        this.age = age;
        this.lap = laptop;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }

    void code(){
        System.out.println("Alien coding....");
        lap.compile();
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }
}
