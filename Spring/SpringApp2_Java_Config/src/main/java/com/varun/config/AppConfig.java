package com.varun.config;


import com.varun.Alien;
import com.varun.Computer;
import com.varun.Desktop;
import com.varun.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    public Laptop laptop(){
        return new Laptop();
    }

    @Bean
    public Alien alien(@Autowired Computer computer){
        Alien alien = new Alien();
        alien.setAge(24);
        alien.setCom(computer);
        return alien;
    }
}
