package com.varun;



public class Alien {

    private int age;

    Alien(){
        System.out.println("Object Created");
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
    }
}
