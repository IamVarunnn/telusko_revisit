package com.varun.config;


import com.varun.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = {"desk", "desktop"})
    public Desktop desktop(){
        return new Desktop();
    }
}
