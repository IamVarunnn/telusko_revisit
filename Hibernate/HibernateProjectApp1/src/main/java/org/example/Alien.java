package org.example;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {

    @Id
    private int aid;
    @Column(name = "alien_name")
    private String aName;
    private String tech;

    @OneToMany
    private List<Laptop> laptops;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }


    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
